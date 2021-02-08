package game.asset;

import org.apache.commons.codec.binary.Hex;

public class Item extends DynamicEntity {
    public Item(final Hex id) {
        super(id);
    }

    public Item(final Hex id, String name) {
        super(id, name);
    }

    public Item(final Hex id, String name, String description) {
        super(id, name, description);
    }
}
