package game.asset.base;

import org.apache.commons.codec.binary.Hex;

public abstract class Asset extends Core {
    public Asset(final Hex id) {
        super(id);
    }

    public Asset(final Hex id, String name) {
        super(id, name);
    }

    public Asset(final Hex id, String name, String description) {
        super(id, name, description);
    }
}