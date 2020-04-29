package game.asset.core;

import game.asset.util.Asset;

import java.util.HashMap;

public class Appearance {
    private HashMap<String, String> looks;

    private int age; // In passed days, when needed will be lazily calculated into months and years
    private double bmi, height, weight;
}
