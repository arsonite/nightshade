package game.engine.exceptions;

public class LevelOutOfBoundsException extends Exception {
	private static final long serialVersionUID = 1508459614515430140L;
	protected static String name = "LevelOutOfBoundsException: ";
	protected static String message = "exceeds the level-cap of '85'.";

	public LevelOutOfBoundsException(int lvl) {
		super((name + "\"" + lvl + "\" " + message));
	}
}