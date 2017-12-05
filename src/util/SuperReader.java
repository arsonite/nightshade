package util;

import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import teaType.data.bi.StringColor;

import teaType.util.io.Reader;

public class SuperReader extends Reader {
	// TODO: Complete and efficient Generalization and overhaul

	///////////////////////////
	/* Customizable fixed Patterns */

	private final Pattern CAT = Pattern.compile("#.*#");
	private final Pattern TYPE = Pattern.compile("!.*!");
	private final Pattern CON = Pattern.compile("-.*-");
	private final Pattern END = Pattern.compile(";;");
	private final Pattern STR = Pattern.compile(".*String.*");
	private final Pattern APPCOL = Pattern.compile(".*app_color.*");

	/* Correspondent Matcher-Objects for further use */
	private Matcher cat, type, con, end, str, appCol;

	/* --------------------- */
	///////////////////////////

	private String[] arr;
	private StringBuilder sb;
	@SuppressWarnings("rawtypes")
	private ArrayList l;
	private ArrayList<ArrayList<?>> allList;
	private ArrayList<ArrayList<String>> strList;

	public SuperReader() {
	}

	private final void compile(String s) {
		cat = CAT.matcher(s);
		type = TYPE.matcher(s);
		con = CON.matcher(s);
		end = END.matcher(s);
		str = STR.matcher(s);
		appCol = APPCOL.matcher(s);
	}
	
	private final void searchPattern(String s) {
	}
	
	private final void cutListEnd(boolean type) {
		if(type) {
			if(end.find()) {
				l.remove(l.size()-1);
				allList.add(l);
			}	
		} else {
			if(end.find()) {
				l.remove(l.size()-1);
				strList.add(l);
			}	
		}
		
	}

	public ArrayList<ArrayList<?>> DEBUG_fileRegexToArrayList() {
		arr = stringArray("./src/_res/raw/#!app.txt");

		allList = new ArrayList<ArrayList<?>>();

		for(String s : arr) {
			compile(s);
			sb = new StringBuilder(s);
			if(str.find()) {
				s = str.group();
				l = new ArrayList<String>();
				continue;
			} else if (appCol.find()) {
				s = appCol.group();
				l = new ArrayList<StringColor>();
				continue;
			} else {
				if(cat.find()) {
					s = cat.group();
				} else if (type.find()) {
					s = type.group();
				} else if(con.find()) {
					s = con.group();
				}
				s = sb.substring(1, s.length()-1);
				l.add(s);
			}
			cutListEnd(true);
		}
		return allList;
	}

	public ArrayList<ArrayList<String>> DEBUG_fileRegexToStringArrayList(String path, boolean skipCat) {
		arr = stringArray(path);
		strList = new ArrayList<ArrayList<String>>();
		l = new ArrayList<String>();

		for(String s : arr) {
			compile(s);
			sb = new StringBuilder(s);
			if(str.find()) {
				s = str.group();
				l = new ArrayList<String>();
				continue;
			} else {
				if(cat.find()) {
					s = cat.group();
					if(skipCat) {
						continue;
					}
				} else if (type.find()) {
					s = type.group();
				} else if(con.find()) {
					s = con.group();
				}
				s = sb.substring(1, s.length()-1);
				l.add(s);
			}
			cutListEnd(false);
		}
		return strList;
	}

	public int[] DEBUG_fileRegexToIntegerArray(String path) {
		arr = stringArray(path);
		ArrayList<String> list = new ArrayList<String>();

		for(String s : arr) {
			compile(s);
			sb = new StringBuilder(s);
			if(cat.find()) {
				s = cat.group();
			} else if (type.find()) {
				s = type.group();
			} else if(con.find()) {
				s = con.group();
			}
			s = sb.substring(1, s.length()-1);
			list.add(s);
		}
		
		if(end.find()) {
			list.remove(list.size()-1);
			list.remove(0);
			list.remove(0);
		}
		
		arr = new String[list.size()];
		
		int[] intArr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
			intArr[i] = Integer.parseInt(arr[i]);
		}

		return intArr;
	}
}