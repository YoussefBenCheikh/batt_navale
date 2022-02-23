package ensta.model.ship;
import ensta.util.*;
public class ShipState {
	
	
	
	protected AbstractShip absShip;
	boolean struck;
	
	public ShipState(AbstractShip absShip, boolean struck) {
		this.absShip = absShip;
		this.struck = struck;
	}
	
	public AbstractShip getShip() {
		return absShip;
	}

	public void addStrike() {
		if (!struck) {
			struck = true;
		absShip.addStrike();
		}
	}
	public boolean isStruck() {
		return struck;
	}
	public String toString() {
		if (struck) 
			return ColorUtil.colorize(absShip.getType().getValue(), ColorUtil.Color.RED);
		return ColorUtil.colorize(absShip.getType().getValue(), ColorUtil.Color.WHITE);
	}
	public boolean isSunk() {
		return absShip.isSunk();
	}
	
}
