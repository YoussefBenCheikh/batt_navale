
import ensta.util.LabelShip;
import ensta.util.LabelShip;
import ensta.util.Orientation;

public abstract class AbstractShip {

	protected LabelShip type;

	protected NameShip name;

	protected Orientation orientation;

	protected LengthShip length;

	public LabelShip getType() {
        return this.type;
    }

    public NameShip getName() {
        return this.name;
    }

    public LengthShip getLength() {
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

    AbstractShip(NameShip name, LabelShip type, LengthShip length, Orientation orientation){
    	this.name = name;
    	this.type = type;
    	this.length = length;
    	this.orientation = orientation;
    }

