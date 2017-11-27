package _debug.test;

import java.io.PrintWriter;
import java.util.Arrays;

import game.asset.NPC;
import game.asset.Player;
import game.asset.core.Appearance;
import game.asset.core.Attributes;
import game.asset.core.Item;
import game.asset.core.Mind;
import game.engine.npc.Interact;
import game.gen.NPC_Generator;

public class NPC_Interaction {
	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(System.out, true);
		
		Appearance app = new Appearance();
		app.setRandom("Male");
		Attributes att = new Attributes();
		att.random(85);
		Mind mnd = new Mind();
		mnd.random();
		Player p = new Player("Burak Günaydin", "Eastern", "Male", 23, app, att, mnd);
		p.addArmor(512);

		Appearance nApp = new Appearance();
		nApp.setRandom("Female");
		Attributes nAtt = new Attributes();
		nAtt.random(15);
		Mind nMnd = new Mind();
		nMnd.random();
		NPC n = new NPC("Lauren", "Southern", "Female", 25, nApp, nAtt, nMnd, false);
//		NPC[] nArr = NPC_Generator.generateNPCS(3);

		Interact.Fight(p, n);
	}
}