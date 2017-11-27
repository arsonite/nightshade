package game.asset;

import java.util.ArrayList;

import game.asset.core.Appearance;
import game.asset.core.Attributes;
import game.asset.core.Character;
import game.asset.core.Focus;
import game.asset.core.Mind;
import game.asset.core.Skill;

public class Player extends Character {
	private String rep;
	private ArrayList<Focus> fcs;
	private ArrayList<Skill> skl;
	private String[] repArr;

	public Player(String name, String race, String sex, int age, Appearance app,  Attributes att, Mind mnd) throws Exception {
		super(name, race, sex, age, app, att, mnd);
		fcs = new ArrayList<Focus>();
		skl = new ArrayList<Skill>();
		flag = true;
	}
	
	public void setReputation(int code) {
		rep = repArr[code];
	}

	public String getReputation() {
		return rep;
	}
	
	public ArrayList<Focus> getFocus() {
		return fcs;
	}
	
	public ArrayList<Skill> getSkills() {
		return skl;
	}
}