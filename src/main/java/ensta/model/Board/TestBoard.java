package ensta.model.Board;

import ensta.util.*;
import ensta.model.ship.*;

import ensta.util.*;
public class TestBoard {
	public static void main(String[] args) {
		
		
		Board brd = new Board("Game",  10);
		
		Destroyer dstryr = new Destroyer();
		Carrier crrr = new Carrier();
		Submarine sbmrn = new Submarine(Orientation.SOUTH);
		Battleship btlshp = new Battleship(Orientation.NORTH);
		
		Coords crd1 = new Coords(4,5);
		Coords crd2 = new Coords(6,6);
		Coords crd3 = new Coords(6,2);
		Coords crd4 = new Coords(10,5);
		try {
		brd.putShip(dstryr, crd2);
		brd.putShip(crrr, crd1);
		brd.putShip(sbmrn, crd3);
		brd.putShip(btlshp, crd4);
		
		} catch(PutShipBoardException excp) {
			excp.printStackTrace();
		}
		brd.print();
		
		brd.sendHit(6, 6);
		brd.sendHit(6, 7);
		brd.print();
	}
}