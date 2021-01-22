package game.asset;

import org.apache.commons.codec.binary.Hex;

import game.asset.base.Entity;

public class DynamicEntity extends Entity {
    public DynamicEntity(final Hex id) {
        super(id);
    }

    public DynamicEntity(final Hex id, String name) {
        super(id, name);
    }

    public DynamicEntity(final Hex id, String name, String description) {
        super(id, name, description);
    }
}
