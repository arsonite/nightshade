package game.asset.core;

import java.util.ArrayList;

import game.asset.util.Asset;
import game.asset.util.Asset_Init;

import teaType.data.bi.StringBoolean;
import teaType.data.bi.StringDouble;
import teaType.data.bi.StringInteger;

import teaType.util.Array;

public class Item extends Asset {
	// TODO: Material like wood, iron, metal etc.
	private String type, wpnType, mat;
	private int[] val;
	private double[] dmgStat;
	private boolean[] bool;
	private StringInteger rare, eq;
	private StringInteger[] vals;
	private StringDouble[] dmgStats;
	private StringBoolean[] use;
	private ArrayList<Status> sts;

	public Item(String name, String desc) {
		super(name, desc);
		val = new int[5];
		bool = new boolean[10];
		eq = new StringInteger("", 0);
		vals = new StringInteger[val.length];
		use = new StringBoolean[bool.length];
		sts = new ArrayList<Status>();
	}

	public final void setEquipCode(int code) {
		if(bool[5]) {
			eq.setInteger(code);
			integerToUtil();
		}
	}

	private final void integerToUtil() {
		eq.setString(Asset_Init.ITEM(false).get(3).get(eq.getInteger()+1));
	}

	private final void valuesToUtil() {
		for(int i = 0; i < vals.length; i++) {
			vals[i] = new StringInteger(Asset_Init.ITEM(false).get(4).get(i+1), val[i]);
		}
	}

	private final void damageToUtil() {
		for(int i = 0; i < dmgStat.length; i++) {
			dmgStats[i] = new StringDouble(Asset_Init.ITEM(false).get(5).get(i+1), dmgStat[i]);
		}
	}

	private final void usageToUtil() {
		for(int i = 0; i < bool.length; i++) {
			use[i] = new StringBoolean(Asset_Init.ITEM(false).get(2).get(i+1), bool[i]);
		}
	}

	public void setRarity(int rare) {
		this.rare = new StringInteger(Asset_Init.ITEM(false).get(1).get(rare), rare);
	}

	public void setType(int type) {
		this.type = Asset_Init.ITEM(false).get(0).get(type);
	}

	public void setWeaponType(int wpnType) {
		if(type.equals("Weapon")) {
			this.wpnType = Asset_Init.ITEM(false).get(6).get(wpnType);
		}
	}

	public void setValues(int prt, int dur, int wgt, int lod, int val) {
		this.val[0] = prt;
		this.val[1] = dur;
		this.val[2] = wgt;
		this.val[3] = lod;
		this.val[4] = val;
		valuesToUtil();
	}

	public void setDamageStats(double dmg, double critChance, double critDmg) {
		if(use[0].getBoolean()) {
			dmgStat = new double[3];
			dmgStats = new StringDouble[dmgStat.length];
			dmgStat[0] = dmg;
			dmgStat[1] = critChance/100;
			dmgStat[2] = critDmg/100;
			damageToUtil();
		}
	}

	public void setUsability(boolean destr, boolean protec, boolean sell, boolean repair,
			boolean ench, boolean equip, boolean loot, boolean mov, boolean ownd, boolean cruc) {
		bool[0] = destr;
		bool[1] = protec;
		bool[2] = sell;
		bool[3] = repair;
		bool[4] = ench;
		bool[5] = equip;
		bool[6] = loot;
		bool[7] = mov;
		bool[8] = ownd;
		bool[9] = cruc;
		usageToUtil();
	}

	public void setStatus() {
	}

	public String getEquipName() { return eq.getString(); }
	public String getRarityName() { return rare.getString(); }
	public String getType() { return type; }
	public String getWeaponType() { return wpnType; }
	
	public String[] getTypes() { return Array.fromArrayList(Asset_Init.ITEM(true).get(0)); }
	public String[] getRarities() { return Array.fromArrayList(Asset_Init.ITEM(true).get(1)); }

	public int getEquipCode() { return eq.getInteger(); }
	public int getRarityNumber() { return rare.getInteger(); }
	public int getProtection() { return val[0]; }
	public int getDurability() { return val[1]; }
	public int getWeight() { return val[2]; }
	public int getLoad() { return val[3]; }
	public int getValue() { return val[4]; }
	
	public int[] getValues() { return val; }

	public double getDamage() { return dmgStat[0]; }
	public double getCriticalChance()  { return dmgStat[1]; }
	public double getCriticalDamage() { return dmgStat[2]; }
	
	public double[] getDamageStats() { return dmgStat; }

	public boolean isDestructive() { return bool[0]; }
	public boolean isProtective() { return bool[1]; }
	public boolean isSellable() { return bool[2]; }
	public boolean isRepairable() { return bool[3]; }
	public boolean isEnchantable() { return bool[4]; }
	public boolean isLootable() { return bool[5]; }
	public boolean isOwned() { return bool[6]; }
	public boolean isCrucial() { return bool[7]; }
	
	public StringInteger getEquip() { return eq; }
	public StringInteger getRarity() { return rare; }
	
	public StringInteger[] getAllValues() { return vals; }
	
	public StringDouble[] getAllDamageStats() { return dmgStats; }

	public StringBoolean[] getUsability() { return use; }
	
	public ArrayList<Status> getStatus() { return sts; }
	
	public int[] getUsabilityCodes() {
		int[] arr = new int[use.length];
		for(int i = 0; i < use.length; i++) {
			if(use[i].getBoolean()) {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}
		return arr;
	}

	public String retrieveStats() {
		String s;
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s%n", getName()));
		for(int i = 0; i < getName().length(); i++) {
			sb.append(String.format("%s", "-"));
		}
		sb.append("\n▪ Description: " + desc);
		sb.append("\n");
		sb.append("\n▪ Info: ");
		sb.append(String.format("%n   » Equipment-Slot %d: %s", eq.getInteger(), eq.getString()));
		sb.append(String.format("%n   » Rarity: %s", rare.getString()));
		sb.append(String.format("%n   » Item-Type: %s", type));
		//		if(!wpnType.isEmpty()) {
		sb.append(String.format("%n   » Weapon-Type: %s", wpnType));
		//		}
		sb.append("\n");
		sb.append("\n▪ Stats:");
		for(StringInteger si : vals) {
			sb.append(String.format("%n   » %s: %d", si.getString(), si.getInteger()));
		}
		sb.append("\n");
		sb.append("\n▪ Usability:");
		for(StringBoolean b : use) {
			sb.append(String.format("%n   » %s: ", b.getString()));
			if(b.getBoolean()) {
				sb.append("Yes");
			} else {
				sb.append("No");
			}
		}
		if(dmgStats != null) {
			sb.append("\n");
			sb.append("\n▪ Damage-Stats:");
			for(int i = 0; i < dmgStats.length; i++) {
				if(i == 0) {
					sb.append(String.format("%n   » %s: %.0f", dmgStats[i].getString(), dmgStats[i].getDouble()));
					continue;
				}
				sb.append(String.format("%n   » %s: %.2f%%", dmgStats[i].getString(), dmgStats[i].getDouble()*100));
			}
		}
		s = sb.toString();
		return s;
	}
}