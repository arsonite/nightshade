package engine.exceptions;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 7877981303066117081L;
	
	protected static String name = "InvalidInputException: ";
	protected static String message = "is not a valid input.";
	
	public InvalidInputException(String input) {
		super((name + "\"" + input + "\" " + message));
    }
}