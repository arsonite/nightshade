package game.asset;

import org.apache.commons.codec.binary.Hex;

import game.asset.base.Entity;

public class StaticEntity extends Entity {
    public StaticEntity(final Hex id) {
        super(id);
    }

    public StaticEntity(final Hex id, String name) {
        super(id, name);
    }

    public StaticEntity(final Hex id, String name, String description) {
        super(id, name, description);
    }
}
