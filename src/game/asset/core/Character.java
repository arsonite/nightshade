package game.asset.core;

import game.asset.Damage;

import math.Functions;

public class Character extends Asset {
    private Attributes attributes;
    private Damage damage;

    public Character(String name, String description) {
        super(name, description);
    }

    // TODO: Revamp for internal double system and external int system
    public final Damage inflictDamage(Damage damage) {
        return new Damage(damage.base() * damage.criticalChance(), Functions.roll(damage.criticalChance()));
    }

    public final Damage calculateDamage() {
        double baseDamage = 1.0;
        double baseCriticalChance = 0.05;
        double baseCriticalDamage = 1.25;

        baseDamage += (baseDamage + this.attributes.get("vigor").value() + this.attributes.get("alacrity").value()) / 2;
        baseCriticalChance += this.attributes.get("alacrity").value() / 768;
        baseCriticalDamage += this.attributes.get("vigor").value() / 256;

        Damage base = new Damage(baseDamage,baseCriticalChance, baseCriticalDamage);
        return base;
    }

    /*
    // TODO: Balancing
    public final static int calculateHealth(int fit, int vig, int age, Blood bld) {
        return Integer.valueOf((int) alphaFormula(age, fit, vig, 10, 1.5, bld));
    }

    // TODO: Balancing
    public final static int calculateStamina(int fit, int alc, int age, Blood bld) {
        return Integer.valueOf((int) alphaFormula(age, fit, alc, 1.5, 2, bld));
    }

    // TODO: Balancing
    public final static int calculateGrant(int trc, Mind m, TeaType<Trait> t) {
        return Integer.valueOf((int) betaFormula(trc));
    }

    public final gainExperience(int experiencePoints) {
        if(experience())
        gammaFormula(experiencePoints, level());

        level = constant * sqrt(XP)
    }

    // TODO: Balancing
    public final int sacrificeHealth(int health) {
        return ((int) ((hlt/16.0) - (betaFormula(trc)/8.0)));
    }

    public final float calculateBloodAmount(String sex, float height, float weight) {
        if(sex.equals("Male")) {
            return Float.valueOf((float) (0.3669 * (Math.pow(height, 3)) + (0.03219 * weight + 0.6041)));
        } else {
            return Float.valueOf((float) (0.3561 * (Math.pow(height, 3)) + (0.03308 * weight + 0.1833)));
        }
    }

    public final static double calculateBMI(float height, float weight) {
        return Float.valueOf((float) (height/(Math.pow(weight, 2))));
    }

    private final double alphaFormula(int age, int firstAttribute, int secondAttribute, double firstFactor, double secondFactor, Blood blood) {
        double rad = (age + 15 + 45) * (Math.PI / 180)
        double ageFactor = 50.0 * Math.sin(rad);
        return new Double((ageFac + (frstAtt * frstFac) + (secAtt * secFac) * bld.getBloodfactor()) * bld.getRemainingFactor());
    }

    private final static double betaFormula(int trc) {
        return ((6.4 + trc) * trc) - ((3.2 + trc) * trc) + (trc / (trc + 16));
    }
    */
}