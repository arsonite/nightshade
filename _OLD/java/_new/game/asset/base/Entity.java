package game.asset.base;

import org.apache.commons.codec.binary.Hex;

public abstract class Entity extends Core {
    public Entity(final Hex id) {
        super(id);
    }

    public Entity(final Hex id, String name) {
        super(id, name);
    }

    public Entity(final Hex id, String name, String description) {
        super(id, name, description);
    }

    public Entity(final Hex id, String name, String description, final boolean foreignID) {
        super(id, name, description, foreignID);
    }
}