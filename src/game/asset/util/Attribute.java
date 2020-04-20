package game.asset.util;

import game.asset.util.Asset;
import game.asset.Buff;

public class Attribute extends Asset {
    public final static int MAX_VALUE = 994;
    public final static int MIN_VALUE = 1;

    private String lethargyDescription;
    private int lethargyFactor;
    private int value;

    private Buff[] buffs;
    private Buff[] debuffs;

    public Attribute(String name, String description) {
        super(name, description);
    }

    public Attribute(String name, String description, int value) {
        super(name, description);
        setValue(value);
    }

    public Attribute(String name, String description, String lethargyDescription, int lethargyFactor) {
        this(name, description);
        setLethargyDescription(lethargyDescription);
        setLethargyFactor(lethargyFactor);
    }

    public Attribute(String name, String description, String lethargyDescription, int lethargyFactor, int value) {
        this(name, description, lethargyDescription, lethargyFactor);
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
