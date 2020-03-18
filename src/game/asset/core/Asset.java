package game.asset.core;

import math.Functions;

public abstract class Asset {
    protected final int id;

    protected String name, description;

    public Asset(String name, String description) {
        setName(name);
        setDescription(description);
        this.id = Functions.hash(name, description);
    }

    public Asset(String name, String description, int id) {
        setName(name);
        setDescription(description);
        this.id = id;
    }

    /* Getter */
    public final int id() { return id; }
    public final String name() { return name; }
    public final String description() { return description; }

    /* Setter */
    public final void setName(String name) { this.name = name; }
    public final void setDescription(String description) { this.description = description; }
}