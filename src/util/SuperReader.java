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

	private final Pattern cat = Pattern.compile("#.*#");
	private final Pattern type = Pattern.compile("!.*!");
	private final Pattern con = Pattern.compile("-.*-");
	private final Pattern end = Pattern.compile(";;");
	private final Pattern string = Pattern.compile(".*String.*");
	private final Pattern appColor = Pattern.compile(".*app_color.*");

	/* Correspondent Matcher-Objects for further use */
	private Matcher mCat;
	private Matcher mType;
	private Matcher mCon;
	private Matcher mEnd;
	private Matcher mString;
	private Matcher mAppColor;

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
		mCat = cat.matcher(s);
		mType = type.matcher(s);
		mCon = con.matcher(s);
		mEnd = end.matcher(s);
		mString = string.matcher(s);
		mAppColor = appColor.matcher(s);
	}
	
	private final void searchPattern(String s) {
	}
	
	private final void cutListEnd(boolean type) {
		if(type) {
			if(mEnd.find()) {
				l.remove(l.size()-1);
				allList.add(l);
			}	
		} else {
			if(mEnd.find()) {
				l.remove(l.size()-1);
				strList.add(l);
			}	
		}
		
	}

	public ArrayList<ArrayList<?>> DEBUG_fileRegexToArrayList() {
		arr = fileToString("./src/_res/raw/#!app.txt");

		allList = new ArrayList<ArrayList<?>>();

		for(String s : arr) {
			compile(s);
			sb = new StringBuilder(s);
			if(mString.find()) {
				s = mString.group();
				l = new ArrayList<String>();
				continue;
			} else if (mAppColor.find()) {
				s = mAppColor.group();
				l = new ArrayList<StringColor>();
				continue;
			} else {
				if(mCat.find()) {
					s = mCat.group();
				} else if (mType.find()) {
					s = mType.group();
				} else if(mCon.find()) {
					s = mCon.group();
				}
				s = sb.substring(1, s.length()-1);
				l.add(s);
			}
			cutListEnd(true);
		}
		return allList;
	}

	public ArrayList<ArrayList<String>> DEBUG_fileRegexToStringArrayList(String path, boolean skipCat) {
		arr = fileToString(path);
		strList = new ArrayList<ArrayList<String>>();
		l = new ArrayList<String>();

		for(String s : arr) {
			compile(s);
			sb = new StringBuilder(s);
			if(mString.find()) {
				s = mString.group();
				l = new ArrayList<String>();
				continue;
			} else {
				if(mCat.find()) {
					s = mCat.group();
					if(skipCat) {
						continue;
					}
				} else if (mType.find()) {
					s = mType.group();
				} else if(mCon.find()) {
					s = mCon.group();
				}
				s = sb.substring(1, s.length()-1);
				l.add(s);
			}
			cutListEnd(false);
		}
		return strList;
	}

	public int[] DEBUG_fileRegexToIntegerArray(String path) {
		arr = fileToString(path);
		ArrayList<String> list = new ArrayList<String>();

		for(String s : arr) {
			compile(s);
			sb = new StringBuilder(s);
			if(mCat.find()) {
				s = mCat.group();
			} else if (mType.find()) {
				s = mType.group();
			} else if(mCon.find()) {
				s = mCon.group();
			}
			s = sb.substring(1, s.length()-1);
			list.add(s);
		}
		
		if(mEnd.find()) {
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