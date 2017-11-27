package _debug.test;

import java.io.PrintWriter;
import java.util.Random;

public class Type_Efficiency {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		Random rnd = new Random();
		
		int[] temp;
		for(int i = 0; i < 1000; i++) {
			rnd.doubles(1000);
		}
	}
}