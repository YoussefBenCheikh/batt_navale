package ensta;

import ensta.ai.*;
import ensta.model.Board.*;
import ensta.model.Hit.Hit;
import ensta.model.ship.*;
import ensta.util.Coords;
import ensta.util.Orientation;
public class TestGame {
	
	private static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	

	public static void main(String[] args) {
		
		Board brd = new Board("Game",  10);
		brd.print();
		int compte_detruit = 0;
		
		AbstractShip ships[] = new AbstractShip[4];
		Destroyer dstryr = new Destroyer();
		Carrier crrr = new Carrier();
		Submarine sbmrn = new Submarine(Orientation.SOUTH);
		Battleship btlshp = new Battleship(Orientation.NORTH);
		
		ships[0]=dstryr;
		ships[1]=crrr;
		ships[2]=sbmrn;
		ships[3]=btlshp;
		
		BattleShipsAI ai = new BattleShipsAI(brd, brd);
		ai.putShips(ships);
		while (compte_detruit<4) {
			
			
			Coords coords = new Coords(0,0);
			
			Hit hit = ai.sendHit(coords);
			if(hit != Hit.MISS && hit!=Hit.STRIKE) compte_detruit=compte_detruit+1;
			System.out.println(coords.getX()+"  "+coords.getY());
			System.out.println(hit);
			brd.print();
			sleep(2000);
			
		}
	}
	
}
