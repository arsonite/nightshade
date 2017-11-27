package game.engine;

import java.io.PrintWriter;

import game.asset.core.Appearance;
import game.asset.core.Attributes;
import game.asset.core.Blood;
import game.asset.core.Character;
import game.asset.core.Conjuration;
import game.asset.core.Inventory;
import game.asset.core.Mind;
import game.asset.core.Status;
import game.asset.core.Trait;

public class CharacterCreation {
	private String name;
	private String sex;
	private int age;
	private int chronoCount = 0;
	private boolean thread;
	private final PrintWriter out = new PrintWriter(System.out, true);
	private Appearance app;
	private Attributes att;
	private Blood bld;
	private Conjuration[] con;
	private Inventory inv;
	private Mind mnd;
	private Status sts;
	private Trait[] trt;

	public CharacterCreation(boolean thread) {
		this.thread = thread;
	}

	public void promptInput() {
		out.println("Please enter: ");
		switch(chronoCount) {
		case 0:
			out.println();
			chronoCount++;
			break;
		case 1:
			out.println();
			chronoCount++;
			break;
		case 2:
			out.println();
			chronoCount++;
			break;
		case 3:
			out.println();
			chronoCount++;
			createAppearance();
			break;
		case 4:
			out.println();
			chronoCount++;
			break;
		case 5:
			out.println();
			chronoCount++;
			break;
		case 6:
			out.println();
			chronoCount++;
			break;
		}	
	}

	private void createAppearance() {
		promptInput();
	}

	private Character createCharacter() throws Exception {
		return new Character(name, age, app, att, null);
	}
}