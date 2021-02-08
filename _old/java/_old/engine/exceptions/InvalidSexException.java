package engine.exceptions;

public class InvalidSexException extends InvalidInputException {
	private static final long serialVersionUID = 8216121514625499798L;
	
	protected final static String message = "Not valid sex.";

	public InvalidSexException(String input) {
		super(input);
	}
}