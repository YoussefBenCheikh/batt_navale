package ensta.model.Board;

import ensta.model.Hit.*;
import ensta.model.ship.AbstractShip;
import ensta.util.Coords;



import ensta.model.ship.AbstractShip;

public interface IBoard { 

    /**
     * Get the size of the grids contained in the Board
     * @return the size of the grids contained in the Board
     */
    public int getSize();

    /**
    * Put the given ship at the given position
    * @param ship The ship to place on the board
    * @param coords
     * @return true if the ship is put on the board
    */
    public void putShip(AbstractShip ship, Coords coords) throws PutShipBoardException;

    /**
     * Get if a ship is placed at the given position
     * @param coords
     * @return true if a ship is located at the given position
     */
    public boolean hasShip(Coords coords);

    /**
     * Set the state of the hit at a given position
     * @param hit true if the hit must be set to successful
     * @param coords
     */
    public void setHit(boolean hit, Coords coords);

    /**
     * Get the state of a hit at the given position
     * @param coords
     * @return true if the hit is successful
     */
    public Boolean getHit(Coords coords);

    /**
     * Sends a hit at the given position
     * @param x
     * @param y
     * @return status for the hit (eg : strike or miss)
     */
    public Hit sendHit(int x, int y);
    

	public boolean canPutShip(AbstractShip ship, Coords coords);
}

