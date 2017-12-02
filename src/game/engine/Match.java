package game.engine;

import java.util.regex.Pattern;

public class Match {
	final Pattern compilePattern(String p1, String p2) { return Pattern.compile("^[" + p1 + "]+[" + p2 + "]+?.*"); }
	
	public final boolean north(String input) { return compilePattern("Nn", "orth").matcher(input).find(); }
	public final boolean south(String input) { return compilePattern("Ss", "outh").matcher(input).find(); }
	public final boolean west(String input) { return compilePattern("Ww", "est").matcher(input).find(); }
	public final boolean east(String input) { return compilePattern("Ee", "ast").matcher(input).find(); }
	
	public final boolean male(String input) { return compilePattern("Mm", "ale").matcher(input).find(); }
	public final boolean female(String input) { return compilePattern("Ff", "emale").matcher(input).find(); }
	
	public final boolean meditate(String input) { return compilePattern("Mm", "editate").matcher(input).find(); }	
	public final boolean remember(String input) { return compilePattern("Rr", "emember").matcher(input).find(); }	
	public final boolean rebirth(String input) { return compilePattern("Rr", "ebirth").matcher(input).find(); }	
	public final boolean suicide(String input) { return compilePattern("Ss", "uicide").matcher(input).find(); }	
	public final boolean think(String input) { return compilePattern("Tt", "hink").matcher(input).find(); }	
	public final boolean awake(String input) { return compilePattern("Aa", "wake").matcher(input).find(); }	
	
	public final boolean check(String input) { return compilePattern("Cc", "heck").matcher(input).find(); }	
	public final boolean status(String input) { return compilePattern("Ss", "tatus").matcher(input).find(); }	
	public final boolean mind(String input) { return compilePattern("Mm", "ind").matcher(input).find(); }	
	public final boolean attributes(String input) { return compilePattern("Aa", "ttributes").matcher(input).find(); }	
	public final boolean inventory(String input) { return compilePattern("Ii", "nventory").matcher(input).find(); }	
	public final boolean skills(String input) { return compilePattern("Ss", "kills").matcher(input).find(); }	
	public final boolean traits(String input) { return compilePattern("Tt", "raits").matcher(input).find(); }	
	public final boolean focus(String input) { return compilePattern("Ff", "ocus").matcher(input).find(); }	
	public final boolean bloodtype(String input) { return compilePattern("Bb", "loodtype").matcher(input).find(); }	
	public final boolean appearance(String input) { return compilePattern("Aa", "ppearance").matcher(input).find(); }	
	
	public final boolean open(String input) { return compilePattern("Oo", "pen").matcher(input).find(); }	
	public final boolean breach(String input) { return compilePattern("Bb", "reach").matcher(input).find(); }	
	public final boolean unlock(String input) { return compilePattern("Uu", "nlock").matcher(input).find(); }	
	public final boolean shut(String input) { return compilePattern("Ss", "hut").matcher(input).find(); }
	
	public final boolean strike(String input) { return compilePattern("Ss", "trike").matcher(input).find(); }
}