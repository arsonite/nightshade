package game.engine.exceptions;

public class ArmorLimitException extends Exception {
	private static final long serialVersionUID = -9048268873119943179L;
	
	protected static String name = "ArmorLimitException: ";
	protected static String message = "exceeds armor limit.";
	
	public ArmorLimitException(String input) {
		super((name + "\"" + input + "\" " + message));
	}
}