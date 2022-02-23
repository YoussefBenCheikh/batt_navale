package ensta.model.Board;
import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.util.Coords;
import ensta.util.*;
import ensta.model.Hit.*;
import ensta.model.ship.*;

public class Board implements IBoard {

	private String name;
	private ShipState[][] ships;
	private boolean[][] hits;

	private static final int DEFAULT_SIZE = 10;
	private static final char EMPTY_SHIP = '.';
	private static final boolean EMPTY_HIT= false;
	
	public Board() {
	}

	public Board(String name, int size) {
		this.name = name;
        this.ships = new ShipState[size][size];
        this.hits = new boolean[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.ships[i][j]= null;
                this.hits[i][j] = EMPTY_HIT;
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
            	if(ships[i][j]!=null)
            		
                System.out.print(ships[i][j].toString() + " ");
            	else System.out.print(". ");
            }
            
            System.out.print(String.format(" %2s ", i + 1));
            
            for(int j = 0; j < hits[0].length; j++){
            	if (hits[i][j]) {
            		if (ships[i][j].isStruck())
            			System.out.print(ColorUtil.colorize("x ", ColorUtil.Color.RED));
            		else System.out.print(ColorUtil.colorize("x ", ColorUtil.Color.WHITE));
            	} else { System.out.print(". ");}
                
            }
            System.out.println();
        }


	}


	public int getSize() {
        return ships.length * ships[0].length;
    }

    public boolean hasShip(Coords coords) {
        return ships[coords.getX()][coords.getY()] != null;
    }

    public Boolean getHit(Coords coords){
    	return hits[coords.getX()][coords.getY()];
    }

    public void setHit(boolean hit, Coords coords) {
        hits[coords.getX()][coords.getY()] = hit;
    }
    
    @Override
    public Hit sendHit(int x, int y) {
    	if(ships[y-1][x-1] == null) {
            return Hit.MISS;
        }
    	ships[y-1][x-1].addStrike();
    	if(ships[y-1][x-1].isSunk()) {
    		System.out.println(ships[y-1][x-1].getShip().getName()+" coulé");
            return Hit.fromInt(ships[y-1][x-1].getShip().getLength().getValue());
            
        }
    	
    	return Hit.STRIKE;

    }
    

	public void putShip(AbstractShip ship, Coords coords) throws PutShipBoardException {

		int x = coords.getX()-1;
		int y = coords.getY()-1;
		int boardsizeX = ships.length;
		int boardsizeY = ships[0].length;
		int shipSize = ship.getLength().getValue();
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		switch (o) {
                case NORTH:
                    dy = -1;
                    break;
                case SOUTH:
                    dy = 1;
                    break;
                case EAST:
                    dx = 1;
                    break;
                case WEST:
                    dx = -1;
                    break;
            }
		//on vérifie que la navire ne sort pas du board
		if ( 
                (x+(shipSize*dx) > boardsizeX ) || 
                (y+(shipSize*dy) > boardsizeY ) ||
                (x+(shipSize*dx) < 0 ) || 
                (y+(shipSize*dy) < 0 ) ||
                (x < 0 ) || 
                (y < 0 )
            )
			
			throw new PutShipBoardException("Off limits");
		
		for (int i = 0; i < shipSize; i++) 
            {//on vérifie que la place n'est pas déja occupé
                if (ships[(i*dx)+x][(i*dy)+y] != null) {
                    while (i > 0) {
                        i--;
                        ships[(i*dx)+x][(i*dy)+y] = null;
                    }
                
                throw new PutShipBoardException("Position occupied");
                }
                
                ships[(i*dx)+x][(i*dy)+y]=new ShipState(ship, false);  
                
            }


	}

	@Override
	public boolean canPutShip(AbstractShip ship, Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setHit(boolean b, int x, int y) {
		// TODO Auto-generated method stub
		 hits[x][y] = b;
	}

	public Object getHit(int x, int y) {
		// TODO Auto-generated method stub
		return hits[x][y];
	}
}
