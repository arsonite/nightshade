package game.asset.util;

import java.util.ArrayList;

import util.SuperReader;

public class Asset_Init {
	private static SuperReader r = new SuperReader();

	public static void main(String[] args) {
	}

	public final static ArrayList<ArrayList<?>> APP() {
		return r.DEBUG_fileRegexToArrayList();
	}

	public final static int[] LVL() {
		return r.DEBUG_fileRegexToIntegerArray("./res/raw/#!exp.txt");
	}

	public final static ArrayList<ArrayList<String>> ITEM(boolean rmvTag) {
		ArrayList<ArrayList<String>> list = r.DEBUG_fileRegexToStringArrayList("./res/raw/#!itm_util.txt", false);
		if(rmvTag) {
			for(ArrayList<String> s : list) {
				s.remove(0);
			}
		}
		return list;
	}
}