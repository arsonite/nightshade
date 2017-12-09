package game.asset.core;

import game.asset.util.Asset;

import teaType.data.bi.StringInteger;

public class Conjuration extends Asset {
	private String type;
	// TODO: SuperReader-Implementation
	private final String[] TYPES = {"Destructive", "Protective", "Auxiliary"};
	private int[] val = new int[4];

	public Conjuration(String name, String desc, int code) {
		super(name, desc);
		type = TYPES[code];
	}
	
	public void setValues(int mod, int dur, int cst, int cha) {
		val[0] = mod;
		val[1] = dur;
		val[2] = cst;
		val[3] = cha;
	}
	
	public String getType() { return type; }
	
	public int getDamage() { return val[0]; }
	public int getProtection() { return val[0]; }
	public int getEffect() { return val[0]; }
	public int getDuration() { return val[1]; }
	public int getCost() { return val[2]; }
	public int getCharges() { return val[3]; }
	
	// TODO: SuperReader-Implementation
	public StringInteger getValues(int code) {
		switch(code) {
		case 0:
			if(type.equals(TYPES[0])) {
				return new StringInteger("Damage", val[0]);
			} else if(type.equals(TYPES[1])) {
				return new StringInteger("Protection", val[0]);
			} else if(type.equals(TYPES[2])) {
				return new StringInteger("Effect", val[0]);
			}
		case 1: return new StringInteger("Duration", val[1]);
		case 2: return new StringInteger("Cost", val[2]);
		case 3: return new StringInteger("Charges", val[3]);
		}
		return null;
	}
}