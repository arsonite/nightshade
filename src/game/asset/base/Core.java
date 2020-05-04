package game.asset.base;

import org.apache.commons.codec.binary.Hex;

public abstract class Core {
    protected final Hex id;

    protected String name, description;

    public Core(final Hex id) {
        this.id = id;
    }

    public Core(final Hex id, String name) {
        this(id);
        setName(name);
    }

    public Core(final Hex id, String name, String description) {
        this(id, name);
        setDescription(description);
    }

    // Getter
    public final Hex id() { return id; }
    public final String name() { return name; }
    public final String description() { return description; }

    // Setter
    public final void setName(String name) { this.name = name; }
    public final void setDescription(String description) { this.description = description; }
}
