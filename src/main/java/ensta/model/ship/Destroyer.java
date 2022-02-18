package ensta.model.ship;

import ensta.util.LabelShip;
import ensta.util.NameShip;
import ensta.util.Orientation;
import ensta.util.ShipLength;

public class Destroyer extends AbstractShip {
	/**
     * Create a new Destroyer with the orientation EAST
     */
    public Destroyer () {
        super(NameShip.DESTROYER, LabelShip.DESTROYER, ShipLength.DESTROYER, Orientation.EAST);
    }

    /**
     * Create a new Destroyer with the orientation provided
     */
    public Destroyer(Orientation orientation){
    	super(NameShip.DESTROYER, LabelShip.DESTROYER, ShipLength.DESTROYER, orientation);
    }
}
