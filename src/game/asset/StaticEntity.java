package game.asset;

import org.apache.commons.codec.binary.Hex;

import game.asset.base.Entity;

public class StaticEntity extends Entity {
    public StaticEntity(final Hex id) {
        super(id);
        setDynamic(false);
    }

    public StaticEntity(final Hex id, String name) {
        super(id, name);
        setDynamic(false);
    }

    public StaticEntity(final Hex id, String name, String description) {
        super(id, name, description);
        setDynamic(false);
    }
}
