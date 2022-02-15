//package ensta.model;

//import ensta.model.ship.AbstractShip;
//import ensta.util.Orientation;

public class Board implements IBoard {
	private String name;
	private Character[][] ships;
	private boolean[][] hits;

	private static final int DEFAULT_SIZE = 10;
	private static final char EMPTY_SHIP_CELL = '.';
	private static final boolean EMPTY_HIT_CELL = false;
	
	public Board() {
	}

	public Board(String name, int size) {
		this.name = name;
        this.ships = new Character[size][size];
        this.hits = new boolean[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.ships[i][j] = EMPTY_SHIP_CELL;
                this.hits[i][j] = EMPTY_HIT_CELL;
            }
        }
    }

	public Board(String name) {
		this(name, DEFAULT_SIZE);
	}


	/**
	 * print the title (Navires:    Frappes:)
	 * @param title
	 * @param boardColumnNumber
	 */

	private void printTitle(String title, int boardColumnNumber){
		System.out.print(title + String.format("%" + (2 * boardColumnNumber - title.length() + 4) + "s", ""));
	}

	/**
	 * print the header (A B C D ..)
	 * @param boardColumnNumber
	 */
	private void printColumnName(int boardColumnNumber){
		System.out.print("   ");
		for(int i = 0; i < boardColumnNumber; i++){
            System.out.print((char)(65 + i) + " ");
        }

	}
	/**
	 * print the grids
	 */
	public void print() {
		printTitle("Navires :", ships[0].length);
		printTitle("Frappes :", hits[0].length);
		System.out.println();
		printColumnName(ships[0].length);
		System.out.print(" ");
		printColumnName(hits[0].length);
		System.out.println();

		for(int i = 0; i < ships.length; i++){
            System.out.print(String.format("%2s ", i + 1));
            
            for(int j = 0; j < ships[0].length; j++){
                System.out.print(ships[i][j] + " ");
            }
            
            System.out.print(String.format(" %2s ", i + 1));
            
            for(int j = 0; j < hits[0].length; j++){
                System.out.print((hits[i][j] ? 'x' : '.') + " ");
            }
            System.out.println();
        }


	}

	// public boolean canPutShip(AbstractShip ship, Coords coords) {
	// 	Orientation o = ship.getOrientation();
	// 	int dx = 0, dy = 0;
	// 	if (o == Orientation.EAST) {
	// 		if (coords.getX() + ship.getLength() >= this.size) {
	// 			return false;
	// 		}
	// 		dx = 1;
	// 	} else if (o == Orientation.SOUTH) {
	// 		if (coords.getY() + ship.getLength() >= this.size) {
	// 			return false;
	// 		}
	// 		dy = 1;
	// 	} else if (o == Orientation.NORTH) {
	// 		if (coords.getY() + 1 - ship.getLength() < 0) {
	// 			return false;
	// 		}
	// 		dy = -1;
	// 	} else if (o == Orientation.WEST) {
	// 		if (coords.getX() + 1 - ship.getLength() < 0) {
	// 			return false;
	// 		}
	// 		dx = -1;
	// 	}

	// 	Coords iCoords = new Coords(coords);

	// 	for (int i = 0; i < ship.getLength(); ++i) {
	// 		if (this.hasShip(iCoords)) {
	// 			return false;
	// 		}
	// 		iCoords.setX(iCoords.getX() + dx);
	// 		iCoords.setY(iCoords.getY() + dy);
	// 	}

	// 	return true;
	// }
}
