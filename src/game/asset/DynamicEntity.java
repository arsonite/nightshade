package game.asset;

import org.apache.commons.codec.binary.Hex;

import game.asset.base.Entity;

public class DynamicEntity extends Entity {
    public DynamicEntity(final Hex id) {
        super(id);
        setDynamic(true);
    }

    public DynamicEntity(final Hex id, String name) {
        super(id, name);
        setDynamic(true);
    }

    public DynamicEntity(final Hex id, String name, String description) {
        super(id, name, description);
        setDynamic(true);
    }
}
