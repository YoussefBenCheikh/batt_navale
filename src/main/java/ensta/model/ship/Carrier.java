package ensta.model.ship;

import ensta.util.LabelShip;
import ensta.util.NameShip;
import ensta.util.Orientation;
import ensta.util.ShipLength;

public class Carrier  extends AbstractShip {
	/**
     * Create a new Carrier with the orientation EAST
     */
    public Carrier () {
        super(LabelShip.CARRIER, NameShip.CARRIER, ShipLength.CARRIER, Orientation.EAST);
    }

    /**
     * Create a new Carrier with the orientation provided
     */
    public Carrier (Orientation orientation){
    	super(LabelShip.CARRIER, NameShip.CARRIER, ShipLength.CARRIER, orientation);
    }
}
