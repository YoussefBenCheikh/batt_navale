package ensta.model.ship;


import ensta.util.LabelShip;
import ensta.util.NameShip;
import ensta.util.Orientation;
import ensta.util.*;

public abstract class AbstractShip {

	protected LabelShip type;

	protected NameShip name;

	protected Orientation orientation;

	protected ShipLength length;

	public LabelShip getType() {
        return this.type;
    }

    public NameShip getName() {
        return this.name;
    }

    public ShipLength getLength() {
        return this.length;
    }


    public Orientation getOrientation() {
        return this.orientation;
    }

    /** 
     * Sets the orientation of the ship
     * @param orientation
     */
    public void setOrientation(Orientation orientation){
    	this.orientation = orientation;
    }

    /** 
     * Create a new ship with label, name, size and orientation provided
     * @param name
     * @param type
     * @param length
     * @param orientation
     */

    public AbstractShip(NameShip name, LabelShip type, ShipLength length, Orientation orientation){
    	this.name = name;
    	this.type = type;
    	this.length = length;
    	this.orientation = orientation;
    }
    public AbstractShip(LabelShip type, NameShip name, ShipLength length, Orientation orientation){
    	this.name = name;
    	this.type = type;
    	this.length = length;
    	this.orientation = orientation;
    }
}

