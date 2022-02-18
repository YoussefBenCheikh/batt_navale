package ensta.model.Board;

public class PutShipBoardException extends Exception {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PutShipBoardException (String reason)
	    {
	        super (" ship cannot be placed in coordinates because: " + reason);
	    }

}


