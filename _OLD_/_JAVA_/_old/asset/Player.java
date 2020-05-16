package asset;

import java.util.TeaType;

import asset.core.Appearance;
import asset.core.Attributes;
import asset.core.Character;
import asset.core.Focus;
import asset.core.Mind;
import asset.core.Skill;

public class Player extends Character {
	private String rep;
	private TeaType<Focus> fcs;
	private TeaType<Skill> skl;
	private String[] repArr;

	public Player(String name, String orig, String sex, int age, Appearance app,  Attributes att, Mind mnd) throws Exception {
		super(name, orig, sex, age, app, att, mnd);
		fcs = new TeaType<Focus>();
		skl = new TeaType<Skill>();
		flag = true;
	}
	
	public void setReputation(int code) {
		rep = repArr[code];
	}

	public String getReputation() {
		return rep;
	}
	
	public TeaType<Focus> getFocus() {
		return fcs;
	}
	
	public TeaType<Skill> getSkills() {
		return skl;
	}
}