package game.asset.core;

import org.apache.commons.codec.binary.Hex;

import game.asset.base.Asset;
import game.asset.Damage;
import game.asset.Player;
import math.Functions;

public abstract class Character extends Asset {
    // Core components
    protected Appearance appearance;
    protected Attributes attributes;
    protected Blood app;
    protected Conjuration[] conjuration;
    protected Equipment equipment;
    protected Focus[] focus;
    protected Inventory inventory;
    protected Mind mind;
    protected Reputation reputation;
    protected Skill[] skills;
    protected Status[] status;
    protected Trait[] traits;

    protected Damage damage;

    protected int ascension, experience, gold, hacksilver, honorbonds;

    public Character(final Hex id) {
        super(id);
    }

    public Character(final Hex id, String name) {
        super(id, name);
    }

    public Character(final Hex id, String name, String description) {
        super(id, name, description);
    }

    public final Damage inflictDamage(Damage damage) {
        return new Damage(damage.base() * damage.criticalChance(), Functions.roll(damage.criticalChance()));
    }

    public Damage calculateDamage() {
        double baseDamage = 1.0;
        double baseCriticalChance = 0.05;
        double baseCriticalDamage = 1.25;

        baseDamage += (baseDamage + this.attributes.get("vigor").value() + this.attributes.get("alacrity").value()) / 2;
        baseCriticalChance += this.attributes.get("alacrity").value() / 768;
        baseCriticalDamage += this.attributes.get("vigor").value() / 256;

        Damage base = new Damage(baseDamage,baseCriticalChance, baseCriticalDamage);
        return base;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Status profile (");
        if (this instanceof Player) {
            sb.append("Player");
        } else {
            sb.append("NPC");
        }

        /*
        sb.append("):\n------------------------\n");
        sb.append(String.format(
                "Name: %s %nOrigin: %s %nSex: %s %nAge: %d %nLevel: %d %nArmor: %d %nHealth: %d %nStamina: %d %nGrant: %d%n",
                getName(), getOrigin(), getSex(), getAge(), getLevel(), getArmor(), getHealth(), getStamina(),
                getGrant()));

        sb.append("\n▪ Appearance:\n");
        sb.append(String.format("   » %.2fm %n   » %.1fkg%n   » BMI-Score: %.1f %n", app.getHeight(), app.getWeight(),
                app.getBMI()));
        for (int i = 0; i < app.getAppearance().size(); i++) {
            if (getSex().equals("Female") && (i == 8 || i == 9)) {
                continue;
            }
            sb.append(String.format("   » %s: %s %n", app.getList().get(i).get(0), app.getAppearance().get(i)));
        }

        sb.append("\n▪ Attributes:");
        for (BiPrimitive a : att.getAttributes(true)) {
            sb.append("\n   » " + a.getFirst() + " - " + a.getSecond());
        }
        sb.append("\n");

        sb.append("\n▪ Bloodtype:\n");
        sb.append(String.format(
                "   » Blood-Status: %s%n   » Blood-State: %d%n   » Bloodfactor: %.2f %n   » Blood-Amount: %.1f%n",
                getBloodtype(), getBloodState(), getBloodfactor(), getBloodAmount()));

        if (!(con.isEmpty())) {
            sb.append("\n");
            sb.append("\n▪ Conjurations:\n");
            for (int i = 0; i < con.size(); i++) {
                sb.append(String.format("      → %s - \"%s\" (Spell-ID: %s)%n", con.get(i).getName(),
                        con.get(i).getDescription(), con.get(i).getID()));
            }
            sb.append("\n");
        }

        if (flag) {
            sb.append("\n▪ Focus:");
            sb.append("\n");
        }

        sb.append("\n▪ Inventory:\n");
        sb.append(String.format("   » Currently equipped: %s%n   » Item-Stache: %n", eq.get(11).getName()));
        for (Item i : eq) {
            if (i != null) {
                // sb.append(String.format("On ", ));
            }
        }
        for (Item i : inv.getInventory()) {
            sb.append(String.format("      → %s - \"%s\" (Item-ID: %s)%n", i.getName(), i.getDescription(), i.getID()));
        }

        sb.append("\n▪ Mind:\n");
        String.format("   » Mind-State: %s, %d%n   » Mind-Progression: %s, %d%n", mnd.getMentalStateToString(),
                mnd.getMentalState(), mnd.getProgressToString(), mnd.getProgress());

        sb.append("   » Civic beliefs:\n");
        for (int i = 0; i < mnd.getCivicBeliefs().length; i++) {
            sb.append(String.format("      → %s: %s%n", mnd.DEBUG_displayAllCivicOptions().get(i).get(0),
                    mnd.getCivicBeliefs()[i]));
        }

        if (flag) {
            sb.append("\n▪ Reputation:\n");
            sb.append("\n");
            sb.append("\n▪ Skills:\n");
            sb.append("\n");
        }

        sb.append("\n▪ Status:\n");
        sb.append("\n");

        sb.append("\n▪ Traits:\n");
        sb.append("\n");

        sb.append(String.format(
                "%n▪ Damage-Stats: %n   » Base Damage:     %.0f = %.0f + %.0f Item-Damage %n   "
                        + "» Critical Damage: %.0f = Base + %.2f%% + %.2f%% Item-Critical-Damage %n"
                        + "   » Critical Chance: %.2f%% = %.2f%% + %.2f%% Item-Critical-Chance %n",
                getDamage(), getBaseDamage(), (eq.get(8).getDamage() + eq.get(11).getDamage()),
                (getBaseDamage() * getCriticalDamage()), (100 * getBaseCriticalDamage() - 100),
                (100 * (eq.get(8).getCriticalDamage() + eq.get(11).getCriticalDamage())), (getCriticalChance() * 100),
                (getBaseCriticalChance() * 80),
                ((eq.get(8).getCriticalChance() + eq.get(11).getCriticalChance()) * 100)));
        */
        return sb.toString();
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