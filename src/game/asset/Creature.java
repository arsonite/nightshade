package game.asset;

import game.asset.core.Appearance;
import game.asset.core.Attributes;
import game.asset.core.Blood;
import game.asset.core.Character;

public class Creature extends Character {
	protected String name;
	protected int age;
	
	public Creature(String name, int age, Appearance app, Attributes att, Blood bld) {
		super(name, age, app, att, bld);
	}
}