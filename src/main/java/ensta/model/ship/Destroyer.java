package ensta.ship;

import ensta.util.LabelShip;
import ensta.util.ShipName;
import ensta.util.Orientation;
import ensta.util.ShipLength;

public class Destroyer extends AbstractShip {
	/**
     * Create a new Destroyer with the orientation EAST
     */
    public Destroyer () {
        super(LabelShip.DESTROYER, ShipName.DESTROYER, ShipLength.DESTROYER, Orientation.EAST);
    }

    /**
     * Create a new Destroyer with the orientation provided
     */
    public Destroyer(Orientation orientation){
    	super(LabelShip.DESTROYER, ShipName.DESTROYER, ShipLength.DESTROYER, orientation);
    }
}
