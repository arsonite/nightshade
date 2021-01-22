package game.asset.core;

import game.asset.base.Asset;
import org.apache.commons.codec.binary.Hex;

import java.util.HashMap;

public class Appearance extends Asset {
    private static HashMap<String, String[]> availableLooks;

    private HashMap<String, String> looks;

    // In passed days, when needed will be lazily calculated into months and years
    private int age, height, weight;
    private double bmi;
    private String origin, sex;
    private String[] pronouns;

    public final static void init() {
        availableLooks = new HashMap<String, String[]>();
    }

    public Appearance(Hex id) {
        super(id);
    }

    // Getter
    public int getAge() { return age; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }
    public double getBmi() { return bmi; }

    // Setter
    public void setAge(int age) { this.age = age; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setBmi(double bmi) { this.bmi = bmi; }
}
