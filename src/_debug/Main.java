package _debug;

import _debug.test.Adventure_Debug;

import game.engine.Adventure_C;
import game.engine.Adventure_I;

import game.gui.SelectionScreen;
import game.gui.SuperContainer;

public class Main {
	public static SuperContainer sC;
	public static SelectionScreen gsS;
	public static SelectionScreen aSS; //Not even on purpose

	public static void main(String[] args) {
		//int launchcode = args[0];
		int launchcode = 0;
		if(launchcode == 0) {
			debug();
		} else {
			launch();
		}
	}
	
	public static void launch() {
		gsS = new SelectionScreen(true);
		gsS.setSize(300, 700, false);
		gsS.display(true);
	}
	
	public static void debug() {
		Adventure_I AD = new Adventure_Debug();
		sC = new SuperContainer(AD);
		sC.setSize(750, 750, true);
		sC.display(true);
	}

	public static void launchAdventure(int game) {
		gsS.close();
		aSS = new SelectionScreen(game, true);
		aSS.setSize(300, 300, false);
		aSS.display(true);
	}

	public static void launchGame(Adventure_C a) {
		aSS.close();
		sC = new SuperContainer(a);
		sC.setSize(750, 750, true);
		sC.display(true);
	}

	public static void repaint() {
		sC.changeAmbience();
	}
}