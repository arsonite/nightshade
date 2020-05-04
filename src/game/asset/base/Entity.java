package game.asset.base;

import org.apache.commons.codec.binary.Hex;

public abstract class Entity extends Core {
    private boolean dynamic;

    public Entity(final Hex id) {
        super(id);
    }

    public Entity(final Hex id, String name) {
        super(id, name);
    }

    public Entity(final Hex id, String name, String description) {
        super(id, name, description);
    }

    // Getter
    public boolean isDynamic() { return dynamic; }

    // Setter
    public void setDynamic(boolean dynamic) { this.dynamic = dynamic; }
}