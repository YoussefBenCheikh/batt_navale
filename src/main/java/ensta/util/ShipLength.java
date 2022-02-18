package ensta.util;
public enum ShipLength {
	
    DESTROYER(2),
    SUBMARINE(3),
    BATTLESHIP(4),
    CARRIER(5);
	
	private int value;
	
	public int getValue() 
    {
        return this.value;
    }

	public String toString()
    {
        return Integer.toString(this.value);
    }
	

	private ShipLength(int value) 
    { 
        this.value = value; 
    } 

}
