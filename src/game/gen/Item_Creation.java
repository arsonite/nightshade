package game.gen;

import java.util.ArrayList;

import game.asset.core.Item;

import teaType.util.io.Writer;

public class Item_Creation {
	private static final String PATH = "./src/_res/pre/common_items.txt";;
	private static boolean create, append, linebreak, extraspace;
	private static ArrayList<Item> items;	
	private static ArrayList<String> list;
	private static Writer w;

	public static void main(String[] args) {
		create = true;
		append = true;
		linebreak = true;
		extraspace = false;

		w = new Writer(PATH);
		items = new ArrayList<Item>();
		list = new ArrayList<String>();

		Item i = new Item("Sword of the Sun", "A peculiar sword, allegedly forged in the warmth of a distant star.");
		i.setUsability(true, true, true, true, true, true, true, true, false, false);
		i.setEquipCode(11);
		i.setValues(10, 75, 5, 3, 10000);
		i.setDamageStats(3500, 35, 350);
		i.setRarity(5);
		i.setType(5);
		i.setWeaponType(10);

		Item i2 = new Item("Helmet of the Sun", "A peculiar Helm, allegedly forged in the warmth of a distant star.");
		i2.setUsability(false, true, true, true, false, true, true, true, false, false);
		i2.setEquipCode(0);
		i2.setValues(50, 125, 10, 5, 5000);
		i2.setRarity(5);
		i2.setType(4);

		printItems();
		addItems(i);
		writeItems();
	}

	private final static void printItems(Item... i) {
		for(Item item : i) {
			System.out.println(item.retrieveStats() + "\n");	
		}
	}

	private final static void addItems(Item... i) {
		for(Item item : i) {
			items.add(item);
		}
	}

	public static void writeItems() {
		for(Item i : items) {
			list.add(convertToString(i));
		}
		w.arraylist(list, create, append, linebreak, extraspace);
	}

	public static String convertToString(Item item) {
		String s = "";
		String[] sym = {"!", "#", "-", ";"};
		StringBuilder sb = new StringBuilder();

		sb.append(sym[0] + item.getID() + sym[0]);
		sb.append("\n");

		sb.append(sym[1] + item.getName() + sym[1]);
		sb.append("\n");

		int[] arr = item.getUsabilityCodes();
		sb.append(sym[2]);
		for(int i = 0; i < arr.length; i++) {
			if(i == item.getUsabilityCodes().length-1) {
				sb.append(arr[i] + sym[2]);
			} else {
				sb.append(arr[i] + " ");
			}
		}
		sb.append("\n");

		sb.append(sym[2] + item.getEquipCode() + sym[2]);
		sb.append("\n");

		arr = item.getValues();
		sb.append(sym[2]);
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length-1) {
				sb.append(arr[i] + sym[2]);
			} else {
				sb.append(arr[i] + " ");
			}
		}
		sb.append("\n");
		
		/*
		i.setDamageStats(3500, 35, 350);
		i.setRarity(5);
		i.setType(5);
		i.setWeaponType(10);
		*/

		sb.append(sym[3] + sym[3]);
		s = sb.toString();
		return s;
	}
}