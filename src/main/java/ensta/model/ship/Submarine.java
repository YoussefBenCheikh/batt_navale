package ensta.ship;

import ensta.util.LabelShip;
import ensta.util.ShipName;
import ensta.util.Orientation;
import ensta.util.ShipLength;

public class Submarine extends AbstractShip {
	/**
     * Create a new Submarine with the orientation EAST
     */
    public Submarine() {
        super(LabelShip.SUBMARINE, ShipName.SUBMARINE, ShipLength.SUBMARINE, Orientation.EAST);
    }

    /**
     * Create a new Submarine with the orientation provided
     */
    public Submarine(Orientation orientation){
    	super(LabelShip.SUBMARINE, ShipName.SUBMARINE, ShipLength.SUBMARINE, orientation);
    }
}
