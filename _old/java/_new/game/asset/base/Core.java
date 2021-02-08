package game.asset.base;

import util.Hex;

public abstract class Core {
    protected final Hex id;

    protected final boolean foreignID;
    protected String name, description;

    public Core(final Hex id) {
        this.id = id;
        this.foreignID = false;
    }

    public Core(final Hex id, String name) {
        this(id);
        setName(name);
    }

    public Core(final Hex id, String name, String description) {
        this(id, name);
        setDescription(description);
    }

    public Core(final Hex id, String name, String description, final boolean foreignID) {
        this.id = id;
        setName(name);
        setDescription(description);
        this.foreignID = false;
    }

    // Getter
    public final Hex id() { return id; }
    public final String name() { return name; }
    public final String description() { return description; }
    public final boolean hasForeignID() { return foreignID; }

    // Setter
    public final void setName(String name) { this.name = name; }
    public final void setDescription(String description) { this.description = description; }
}
