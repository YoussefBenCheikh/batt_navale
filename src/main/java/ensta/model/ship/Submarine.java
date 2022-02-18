package ensta.model.ship;

import ensta.util.*;



public class Submarine extends AbstractShip {
	/**
     * Create a new Submarine with the orientation EAST
     */
    public Submarine() {
        super(LabelShip.SUBMARINE, NameShip.SUBMARINE, ShipLength.SUBMARINE, Orientation.EAST);
    }

    /**
     * Create a new Submarine with the orientation provided
     */
    public Submarine(Orientation orientation){
    	super(LabelShip.SUBMARINE, NameShip.SUBMARINE, ShipLength.SUBMARINE, orientation);
    }
}
