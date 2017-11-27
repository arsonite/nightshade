package _debug.old;

import java.io.PrintWriter;

import game.asset.Player;
import game.asset.core.Appearance;
import game.asset.core.Attributes;
import game.asset.core.Blood;
import game.asset.core.Focus;
import game.asset.core.Inventory;
import game.asset.core.Mind;
import game.asset.core.Skill;
import game.asset.core.Status;
import game.asset.core.Trait;

public class temp {
	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(System.out, true);

		/**
		CC_SpellHandler s = new CC_SpellHandler();
		System.out.println(s.getConjuration(0).getValues(1).getValueType() + "\n");
		 */

		/**
		Mind m = new Mind();
		m.debug();
		m.setMind(1756);
		System.out.println(m.getMentalState() + " " + m.getProgress() + "\n");
		for(int i = 0; i < 9; i++) {
			m.addGoodwill(true, 249);
			System.out.println(m.getMentalState() + " " + m.getProgress() + "\n");
		}
		 **/

		/**
		int count = 1000;
		int dmg;
		int critCount = 0;
		String crit;
		for (int i = 0; i < count; i++) {
			dmg = Functions.damageOutput(25, 3, 100);
			crit = Functions.debugCritStats();
			System.out.println(dmg + crit);
			if (crit != null) {
				critCount++;
			}
		}
		System.out.println("\n" + "Percentage of crits: " + critCount*100/count);
		System.out.println("Number of crits: " + critCount);
		 **/

		/**
		Adventure a = new Adventure("test", "test", 1);
		NPC tom = new NPC("Tom", "Sir", null, null, null, null, null, null, null, false);
		NPC paul = new NPC("Paul", null, null, null, null, null, null, null, null, false);
		NPC nick = new NPC("Nick", null, null, null, null, null, null, null, null, false);
		NPC liza = new NPC("Liza", "Lady", null, null, null, null, null, null, null, true);
		a.addNPC(tom);
		a.addNPC(paul);
		a.addNPC(nick);
		a.addNPC(liza);
		ArrayList<NPC> n = a.getNPCS();
		for (NPC test : n) {
			System.out.println(test.getName());
  		}
		 **/

		

		/**
		double[] kimVal = {17, 50, 50, 1};
		Appearance kimApp = new Appearance();
		Attributes kimAtt = new Attributes();
		Bloodtype kimBld = new Bloodtype();
		Inventory kimInv = new Inventory();
		Mind kimMnd = new Mind();
		Status kimSts = new Status();
		Trait kimTrt = new Trait(null, null, 0);
		NPC kim = new NPC("Kim", "Lady", kimVal, kimApp, kimAtt, kimBld, kimInv, kimMnd, kimSts, null, true);
		kim.setProfession(0);
		out.println(kim.getTitle() + " " + kim.getName() + "\n" + "--------");
		out.println("Stand: " + kim.getProfession());
		out.println("Sex: " + kim.getSex());
		out.println("Age: " + kim.getAge());
		double[] b1Val = {19, 75, 75, 0};
		NPC bandit_1 = new NPC("Taunting Tom", "Bandit", b1Val, null, null, null, null, null, null, null, false);
		 **/

		/**
		int[] burakVal = {22, 125, 100, 0};
		Attributes burakAtt = new Attributes();
		CC_TraitHandler tH = new CC_TraitHandler();
		Mind m = new Mind();
		Trait[] t = new Trait[2];
		burakAtt.randomAttributes();
		Player burak = new Player("Burak Günaydin", burakVal, null, burakAtt, null, null, null, m, null, null, null, t);
		burak.calculateDamage(0);
		burak.giveArmor(0.15);
		int[] pirateVal = {19, 100, 100, 0};
		Attributes pirateAtt = new Attributes();
		NPC pirate = new NPC("Dirty Dieter", "Pirate", pirateVal, null, pirateAtt, null, null, null, null, null, false);
		pirateAtt.setAttributes(100, 100, 50, 50, 50, 50, 50);
		pirate.calculateDamage(100);
		double pirateDmg = pirate.inflictDamage();
		double burakDmg;
		out.println(burak.getName() + " has " + burak.getHealth() + " Health!");
		burak.takeDamage(pirateDmg);
		out.printf("Burak took %.2f Damage! He has %d Health left! Burak is dead: %b", pirateDmg, burak.getHealth(), burak.isDead());
		 **/

		/**
		Attributes a = new Attributes();
		a.randomAttributes();
		for(Att_Util aT : a.getAttributes()) {
			System.out.println(aT.getAttribute() + " " + aT.getValue());
		}
		System.out.println(a.isGodlike());
		 **/

		//		Attributes a = new Attributes();
		//		a.randomAttributes();
		//		NPC oldDude = new NPC(null, null, 70, null, null, a, null, null, null, null, null, false);
		//		out.println(oldDude.getAge());
		//		out.println(oldDude.getHealth());
		out.println((double) (83.0/90.0*100-90-1));
	}
}