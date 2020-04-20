package game.asset.factories;

import game.asset.util.Attribute;

public class AttributeFactory {
    private String name;
    private String description;
    private String lethargyDescription;
    private int lethargyFactor;
    private int value;

    private Attribute attribute;

    public AttributeFactory() {
        // TODO: SuperReader
    }

    public Attribute build() {
        return new Attribute(this.name, this.description, this.lethargyDescription, this.lethargyFactor, this.value);
    }

    /* SETTER */
    public void name(String name) { this.name = name; }
    public void description(String description) { this.description = description; }
    public void lethargyDescription(String lethargyDescription) { this.lethargyDescription = lethargyDescription; }
    public void lethargyFactor(int lethargyFactor) { this.lethargyFactor = lethargyFactor; }
    public void value(int value) { this.value = value; }
}