package ensta.util;
import java.util.Random;

public class Coords {

	private int x;
	private int y;

	public Coords(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX(){return x;}
	public int getY(){return y;}

	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}

	public void setCoords(Coords res) {
		// TODO Auto-generated method stub
		this.x = res.getX();
		this.y = res.getY();
		
	}

	public static Coords randomCoords(int size) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x = rand.nextInt(size);
		int y = rand.nextInt(size);
		Coords crd = new Coords(x,y);
		return crd;
	}


}