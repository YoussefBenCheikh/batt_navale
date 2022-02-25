package ensta.ai;

import java.io.Serializable;
import java.util.Random;

import ensta.util.Coords;
import ensta.model.Hit.*;
import ensta.model.Board.IBoard;
import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class BattleShipsAI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * ** Attributs
	 */

	/**
	 * My board. My ships have to be put on this one.
	 */
	private final IBoard board;

	/**
	 * My opponent's board. My hits go on this one to strike his ships.
	 */
	private final IBoard opponent;

	/**
	 * Coordss of last known strike. Would be a good idea to target next hits around
	 * this point.
	 */
	private Coords lastStrike;

	/**
	 * If last known strike lead me to think the underlying ship has vertical
	 * placement.
	 */
	private Boolean lastVertical;

	/*
	 * ** Constructeur
	 */

	/**
	 *
	 * @param myBoard       board where ships will be put.
	 * @param opponentBoard Opponent's board, where hits will be sent.
	 */
	public BattleShipsAI(IBoard myBoard, IBoard opponentBoard) {
		this.board = myBoard;
		this.opponent = opponentBoard;
	}

	/*
	 * ** Méthodes publiques
	 */

	/**
	 * Put the ships on owned board.
	 * 
	 * @param ships the ships to put
	 */
	public void putShips(AbstractShip ships[]) {
		int x, y;
        Random rnd = new Random();

		Coords coords = new Coords(0,0);
		Orientation[] orientations = Orientation.values();

		for (AbstractShip ship : ships) {
			do {
				// TODO use Random to pick a random x, y & orientation
				x = rnd.nextInt(board.getSize());
                y = rnd.nextInt(board.getSize());
                ship.setOrientation(orientations[rnd.nextInt(orientations.length)]);
                coords.setX(x);
                coords.setY(y);
			} while (!board.canPutShip(ship, coords));
			try {
                board.putShip(ship, coords);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

		}
	}

	/**
	 *
	 * @param coords array must be of size 2. Will hold the coords of the send hit.
	 * @return the status of the hit.
	 */
	public Hit sendHit(Coords coords) {
		//System.out.println("here 1");
		Coords res = null;
		if (coords == null) {
			throw new IllegalArgumentException("must provide an initialized array of size 2");
		}
		//System.out.println("here 2");
		// already found strike & orientation?
		if (lastVertical != null) {
			if (lastVertical) {
				res = pickVCoords();
			} else {
				res = pickHCoords();
			}
			//System.out.println("here 5");
			if (res == null) {
				// no suitable coords found... forget last strike.
				lastStrike = null;
				lastVertical = null;
			}
		} else if (lastStrike != null) {
			// if already found a strike, without orientation
			// try to guess orientation
			res = pickVCoords();
			if (res == null) {
				res = pickHCoords();
			}
			if (res == null) {
				// no suitable coords found... forget last strike.
				lastStrike = null;
			}
		}
		//System.out.println("here 6");
		if (lastStrike == null) {
			res = pickRandomCoords();
		}
		//System.out.println("here 7");
		Hit hit = opponent.sendHit(res);
		board.setHit(hit != Hit.MISS, res);

		if (hit != Hit.MISS) {
			if (lastStrike != null) {
				lastVertical = guessOrientation(lastStrike, res);
			}
			lastStrike = res;
		}
		//System.out.println("here 8");
		coords.setCoords(res);
		
		return hit;
	}

	/*
	 * *** Méthodes privées
	 */

	private boolean guessOrientation(Coords lastStrike2, Coords res) {
		return lastStrike2.getY() == res.getY();
	}

	private boolean isUndiscovered(Coords coords) {
		//return coords.isInBoard(board.getSize()) && board.getHit(coords) == null;
		int x = coords.getX();
		int y = coords.getY();
		return -1<x && -1<y && x<board.getSize() && y<board.getSize() && board.getHit(coords) == null;
	}

	private Coords pickRandomCoords() {
		
		Coords coords;
		do {
			coords = Coords.randomCoords(board.getSize());
		} while (!isUndiscovered(coords));
		
		return coords;
	}

	/**
	 * pick a coords verically around last known strike
	 * 
	 * @return suitable coords, or null if none is suitable
	 */
	private Coords pickVCoords() {
		int x = lastStrike.getX();
		int y = lastStrike.getY();

		for (int iy : new int[] { y - 1, y + 1 }) {
			Coords coords = new Coords(x, iy);
			if (isUndiscovered(coords)) {
				return coords;
			}
		}
		return null;
	}

	/**
	 * pick a coords horizontally around last known strike
	 * 
	 * @return suitable coords, or null if none is suitable
	 */
	private Coords pickHCoords() {
		int x = lastStrike.getX();
		int y = lastStrike.getY();

		for (int ix : new int[] { x - 1, x + 1 }) {
			Coords coords = new Coords(ix, y);
			if (isUndiscovered(coords)) {
				return coords;
			}
		}
		return null;
	}
}
