package ensta.model.Board;


import ensta.model.ship.*;

import ensta.util.*;
public class TestBoard {
	public static void main(String[] args) {
		
		Board brd = new Board("Game",  10);
		Destroyer dstryr = new Destroyer();
		Coords crd = new Coords(4,3);
		brd.putShip(dstryr, crd);
		brd.print();
	}
}