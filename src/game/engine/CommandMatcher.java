package game.engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandMatcher {
	final Pattern compilePattern(String p1, String p2) { return Pattern.compile("^[" + p1 + "]+[" + p2 + "]+?.*"); }
	
	public final Matcher getNorth(String input) { return compilePattern("Nn", "orth").matcher(input); }
	public final Matcher getSouth(String input) { return compilePattern("Ss", "outh").matcher(input); }
	public final Matcher getWest(String input) { return compilePattern("Ww", "est").matcher(input); }
	public final Matcher getEast(String input) { return compilePattern("Ee", "ast").matcher(input); }
	
	public final Matcher getMale(String input) { return compilePattern("Mm", "ale").matcher(input); }
	public final Matcher getFemale(String input) { return compilePattern("Ff", "emale").matcher(input); }
	
	public final Matcher getMeditate(String input) { return compilePattern("Mm", "editate").matcher(input); }	
	public final Matcher getRemember(String input) { return compilePattern("Rr", "emember").matcher(input); }	
	public final Matcher getRebirth(String input) { return compilePattern("Rr", "ebirth").matcher(input); }	
	public final Matcher getSuicide(String input) { return compilePattern("Ss", "uicide").matcher(input); }	
	public final Matcher getThink(String input) { return compilePattern("Tt", "hink").matcher(input); }	
	public final Matcher getAwake(String input) { return compilePattern("Aa", "wake").matcher(input); }	
	
	public final Matcher getCheck(String input) { return compilePattern("Cc", "heck").matcher(input); }	
	public final Matcher getStatus(String input) { return compilePattern("Ss", "tatus").matcher(input); }	
	public final Matcher getMind(String input) { return compilePattern("Mm", "ind").matcher(input); }	
	public final Matcher getAttributes(String input) { return compilePattern("Aa", "ttributes").matcher(input); }	
	public final Matcher getInventory(String input) { return compilePattern("Ii", "nventory").matcher(input); }	
	public final Matcher getSkills(String input) { return compilePattern("Ss", "kills").matcher(input); }	
	public final Matcher getTraits(String input) { return compilePattern("Tt", "raits").matcher(input); }	
	public final Matcher getFocus(String input) { return compilePattern("Ff", "ocus").matcher(input); }	
	public final Matcher getBloodtype(String input) { return compilePattern("Bb", "loodtype").matcher(input); }	
	public final Matcher getAppearance(String input) { return compilePattern("Aa", "ppearance").matcher(input); }	
	
	public final Matcher getOpen(String input) { return compilePattern("Oo", "pen").matcher(input); }	
	public final Matcher getBreach(String input) { return compilePattern("Bb", "reach").matcher(input); }	
	public final Matcher getUnlock(String input) { return compilePattern("Uu", "nlock").matcher(input); }	
	public final Matcher getShut(String input) { return compilePattern("Ss", "hut").matcher(input); }
}