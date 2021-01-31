package exception;

/*
 * Input Parser Exception class
 * To return an appropriate message when incorrect input in provided
 * */

public class ParsingException extends Exception {
	
	private static final long serialVersionUTD =1L;
	
	public ParsingException(String message) {
		super(message);
	}
}
