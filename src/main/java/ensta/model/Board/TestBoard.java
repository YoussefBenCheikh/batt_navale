public class TestBoard
{
	public static void main(String[] args) {
		
		Board brd = new Board(args[0],  Integer.parseInt(args[1]));
		
		brd.print();
	}
}