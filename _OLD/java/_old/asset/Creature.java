package asset;

import asset.core.Appearance;
import asset.core.Attributes;
import asset.core.Character;
import asset.core.Mind;

public class Creature extends Character {
	public Creature(String name, String orig, String sex, int age, Appearance app, Attributes att, Mind mnd)
			throws Exception {
		super(name, orig, sex, age, app, att, mnd);
		// TODO Auto-generated constructor stub
	}
	protected String name;
	protected int age;
	
	//public Creature(String name, int age, Appearance app, Attributes att, Blood bld) {
	//}
}