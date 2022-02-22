package ensta.model.ship;
import ensta.util.*;
public class ShipState {
	
	
	
	public AbstractShip absShip;
	boolean struck;
	
	public ShipState(AbstractShip absShip, boolean struck) {
		this.absShip = absShip;
		this.struck = struck;
	}
	

	public void addStrike() {
		struck = true;
		absShip.addStrike();
	}
	public boolean isStruck() {
		return struck;
	}
	public String toString() {
		if (struck) 
			return ColorUtil.colorize(absShip.getType().getValue(), ColorUtil.Color.RED);
		return ColorUtil.colorize(absShip.getType().getValue(), ColorUtil.Color.WHITE);
	}
	
}
