package ensta.model.Player;
import ensta.model.Board.*;
import ensta.model.Hit.Hit;
import ensta.model.ship.*;
import ensta.util.*;
import java.io.Serializable;
import java.util.List;

import ensta.model.ship.AbstractShip;
import ensta.view.InputHelper;

public class Player {
	/*
	 * ** Attributs
	 */
	private Board board;
	protected Board opponentBoard;
	private int destroyedCount;
	protected AbstractShip[] ships;
	private boolean lose;

	/*
	 * ** Constructeur
	 */
	public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
		this.setBoard(board);
		this.ships = ships.toArray(new AbstractShip[0]);
		this.opponentBoard = opponentBoard;
	}

	/*
	 * ** Méthodes
	 */

	/**
	 * Read keyboard input to get ships coordinates. Place ships on given
	 * coodrinates.
	 */
	public void putShips() {
		boolean done = false;
		int i = 0;

		do {
			 try {
				 //System.out.println("here1");
			AbstractShip ship = ships[i];
			//System.out.println("here2");
			String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getLength().getValue());
			//System.out.println("here3");
			System.out.println(msg);
			//System.out.println("here4");
			InputHelper.ShipInput res = InputHelper.readShipInput();
			//System.out.println("here5");
			System.out.println("X: " + res.x + " Y: " + res.y);
			//System.out.println("here6");
            ship.setOrientation(Orientation.fromString(res.orientation));
            System.out.println(Orientation.fromString(res.orientation));
           // System.out.println("here7");
            Coords crd = new Coords(res.x,res.y);
           // System.out.println("here8");
            board.putShip(ship, crd);
            
            //System.out.println("here9");
			// TODO set ship orientation
			// TODO put ship at given position
			// TODO when ship placement successful
			++i;
			done = i == 5;
			//System.out.println("here3");
			board.print();
			} catch(Exception e) {
	              System.out.println(e.getMessage());
	        }

		} while (!done);
	}

	public Hit sendHit(Coords coords) {
		boolean done = false;
		Hit hit = null;

		do {
			System.out.println("où frapper?");
			InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
			// TODO call sendHit on this.opponentBoard
			
			if(board.getHit(hitInput.x, hitInput.y) == null) {
				hit=this.opponentBoard.sendHit(hitInput.x, hitInput.y);
				// TODO : Game expects sendHit to return BOTH hit result & hit coords.
				// return hit is obvious. But how to return coords at the same time ?
				board.setHit(hit != Hit.MISS, hitInput.x, hitInput.y);
				coords.setX(hitInput.x);
				coords.setY(hitInput.y);
				done=true;
			}
			else {
				System.out.println("coup déja fait, choisissez d'autres coordonnées.");
			}
		} while (!done);

		return hit;
	}

	public AbstractShip[] getShips() {
		return ships;
	}

	public void setShips(AbstractShip[] ships) {
		this.ships = ships;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getDestroyedCount() {
		return destroyedCount;
	}

	public void setDestroyedCount(int destroyedCount) {
		this.destroyedCount = destroyedCount;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}
}
