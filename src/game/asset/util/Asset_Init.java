package game.asset.util;

import java.util.ArrayList;

import teaType.util.Array;

import util.SuperReader;

public class Asset_Init {
	// TODO: Write class as initial loading class, started in the main, and everything read and loaded after first loading screen
	// informations all stored in variable. write class as entirely static or singleton

	
	static SuperReader r = new SuperReader();
	
	// TODO: Write paths into main and set paths through methods
	/* FILE-PATH CONSTANTS */
	
	final static String LVL = "./res/raw/#!exp.txt";
	final static String APP = "";
	final static String ITM = "./res/raw/#!itm_util.txt";
	final static String MAT = "./res/raw/#!mat.txt";
	
	/* ------------------- */
	
	public final static String[] MATCH() {
		return Array.fromArrayList(r.DEBUG_fileRegexToStringArrayList(MAT, true).get(0));
	}

	public final static ArrayList<ArrayList<?>> APP() {
		return r.DEBUG_fileRegexToArrayList();
	}

	public final static int[] LVL() {
		return r.DEBUG_fileRegexToIntegerArray(LVL);
	}

	public final static ArrayList<ArrayList<String>> ITEM(boolean rmvTag) {
		ArrayList<ArrayList<String>> list = r.DEBUG_fileRegexToStringArrayList(ITM, false);
		if(rmvTag) {
			for(ArrayList<String> s : list) {
				s.remove(0);
			}
		}
		return list;
	}
}