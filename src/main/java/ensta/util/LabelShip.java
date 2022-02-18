package ensta.util;


public enum LabelShip{

	BATTLESHIP('B'),
	CARRIER('C'),
	DESTROYER('D'),
    SUBMARINE('S');
        
	private char value; 
	
	public char getValue() 
    {
        return this.value;
    }

	public String toString()
    {
        return Character.toString(this.value);
    }

	private LabelShip(char value) 
    { 
        this.value = value; 
    } 

        
}