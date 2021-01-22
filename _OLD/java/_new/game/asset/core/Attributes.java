package game.asset.core;

import java.util.HashMap;

import org.apache.commons.codec.binary.Hex;

import game.asset.Buff;
import game.asset.base.Asset;

/**
 * The class {@code Attribute}
 *
 * @author Burak Günaydin
 */
class Attribute extends Asset {
    public final static int MAX_VALUE = 994;
    public final static int MIN_VALUE = 1;

    private String lethargyDescription;
    private int lethargyFactor;
    private int value;

    public Attribute(final Hex id, String name, String description) {
        super(id, name, description);
    }

    public Attribute(final Hex id, String name, String description, int value) {
        super(id, name, description);
        setValue(value);
    }

    public Attribute(final Hex id, String name, String description, String lethargyDescription, int lethargyFactor) {
        this(id, name, description);
        setLethargyDescription(lethargyDescription);
        setLethargyFactor(lethargyFactor);
    }

    public Attribute(final Hex id, String name, String description, String lethargyDescription, int lethargyFactor, int value) {
        this(id, name, description, lethargyDescription, lethargyFactor);
        setValue(value);
    }

    public final void increase(int points) {
        this.value += points;
    }

    public final void decrease(int points) {
        this.value -= points;
    }

    /* GETTER */
    public String lethargyDescription() { return lethargyDescription; }
    public int lethargyFactor() { return lethargyFactor; }
    public int value() { return value; }

    /* SETTER */
    public void setLethargyDescription(String lethargyDescription) { this.lethargyDescription = lethargyDescription; }
    public void setLethargyFactor(int lethargyFactor) { this.lethargyFactor = lethargyFactor; }
    public void setValue(int value) { this.value = value; }
}

/**
 * The class {@code Attributes} contains the methods necessary to determine
 * the amount of experience-points, the level and the character-attributes
 * of all the non-playable and playable characters in the game.
 * This ranges from humans to creatures to bosses.
 *
 * <p>{@code Attributes} is part of every {@code Character} and its subclasses.
 *
 * @author Burak Günaydin
 */
public class Attributes {
    private HashMap<String, Attribute> attributes;

    public final static int EXP_CONSTANT = 256;
    public final static int MAX_LEVEL = 100;

    private int level;
    private int experience;
    private int maxHealth;
    private int maxStamina;
    private int maxGrant;
    private int health;
    private int stamina;
    private int grant;
    private int thirst = 0;
    private int calories = 2000;

    public Attributes(boolean random) {
        if(random) {
            int randomLevel = (int) (Math.random() * Attributes.MAX_LEVEL);
        }
        this.attributes = new HashMap<>(7);
    }

    /*
    public final static int calculateExperience(int level) {
        return (int) (Attributes.EXP_CONSTANT * Math.pow(2, level / 16));
    }


	if (lvl < 1) {
		return;
	}
	return (lvl + 160.5) * Math.pow(2, lvl / 9);

    public final int calculateLethargy(int[] att) {
        double[] temp = new double[att.length];
        for(int i = 0; i < att.length; i++) {
            temp[i] = Math.log(att[i]);
        }
        double incr = (temp[1] + temp[3] + temp[6] + temp[5]) * 2.56;
        double decr = (temp[0] + temp[2] + temp[4]) * 1.28;
        double sum = (incr - decr) * 0.512;
        if(sum < 1) {
            sum+= Math.abs(sum) + 1;
        }
        return new Integer((int) sum);
    }


        this.attributes.put("alacrity", new Attribute('', '', ));
        this.attributes.put("awareness", );
        this.attributes.put("brilliance", );
        this.attributes.put("empathy", );
        this.attributes.put("fitness", );
        this.attributes.put("transcendence", );
        this.attributes.put("vigor", );


    /**
     * An efficient random-generation algorithm, which distributes a certain number of given experience-points
     * randomly between a fixed amount of attributes.
     *
     * @param lvl A parameter containing the amount of character-levels,
     * 		  which depict the amount of available experience-points
     * @throws Exception
     */
    /*
    public void random(int lvl) throws Exception {
        Random rnd = new Random();
        int bonusEXP;
        if(lvl > 1 && lvl <= 83) {
            bonusEXP = 7 * lvl;
        } else if (lvl > 83) {
            bonusEXP = (7 * lvl) + (int) (lvl / 90.0 * 100 - 90 + 1);
        } else if (lvl > 85) {
            throw new LevelOutOfBoundsException(lvl);
        } else {
            bonusEXP = 0;
        }
        int m = 101 + bonusEXP;
        int min = 1;
        int max = m - min * 7;
        for(int i = 1; i < att.length; i++) {
            att[i]+= rnd.nextInt(max);
        }
        Arrays.sort(att, 1, att.length);
        for(int i = 1; i < att.length; i++) {
            att[i-1] = att[i] - att[i-1] + min;
        }
        att[att.length-1] = max - att[att.length-1] + min;
        attributesToUtil();
    }

    function randomizeAttributes(lvl) {
	let points = 7;
	let base = 70;
	let min = 1;
	let sum = base + points * lvl;
	let att = [];

	let rSum = 0;
	for (let i = 0; i < 7; i++) {
		let r = round(Math.random() * sum + min);
		att[i] = r;
		rSum += r;
	}
	let co = sum / rSum;
	rSum = 0;
	for (let i = 0; i < att.length; i++) {
		att[i] = round(att[i] * co);
		rSum += att[i];
	}

	if (rSum > sum) {
		let r = round(Math.random() * 7);
		let diff = rSum - sum;
		att[r] -= diff;
	} else if (rSum < sum) {
		let r = round(Math.random() * 7);
		let diff = sum - rSum;
		att[r] += diff;
	}

	return att;
}
     */

    public Attribute get(String attribute) {
        return this.attributes.get(attribute);
    }

    /* GETTER */
    public int level() { return level; }
    public int experience() { return experience; }
    public int maxHealth() { return maxHealth; }
    public int maxStamina() { return maxStamina; }
    public int maxGrant() { return maxGrant; }
    public int health() { return health; }
    public int stamina() { return stamina; }
    public int grant() { return grant; }
    public HashMap<String, Attribute> attributes() { return attributes; }

    /* SETTER */
    public void setLevel(int level) { this.level = level; }
    public void setExperience(int experience) { this.experience = experience; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setMaxStamina(int maxStamina) { this.maxStamina = maxStamina; }
    public void setMaxGrant(int maxGrant) { this.maxGrant = maxGrant; }
    public void setHealth(int health) { this.health = health; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public void setGrant(int grant) { this.grant = grant; }
    public void setAttributes(HashMap<String, Attribute> attributes) { this.attributes = attributes; }
}
