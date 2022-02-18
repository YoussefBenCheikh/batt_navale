package ensta.ship;
import ensta.util.NameShip;
import ensta.util.LabelShip;

import ensta.util.Orientation;
import ensta.util.ShipLength;

public class Battleship  extends AbstractShip {
	/**
     * Create a new Battleship  with the orientation EAST
     */
    public Battleship () {
        super(LabelShip.BATTLESHIP, NameShip.BATTLESHIP, ShipLength.BATTLESHIP, Orientation.EAST);
    }

    /**
     * Create a new Battleship  with the orientation provided
     */
    public Battleship (Orientation orientation){
    	super(LabelShip.BATTLESHIP, NameShip.BATTLESHIP, ShipLength.BATTLESHIP, orientation);
    }
}
