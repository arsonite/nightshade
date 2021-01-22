package game.asset;

import org.apache.commons.codec.binary.Hex;

import game.asset.core.Character;

public class Player extends Character {
    private final boolean survivalMode;
    private final boolean hardcoreMode;

    public Player(final Hex id, String name, String description) {
        super(id, name, description);

        survivalMode = true;
        hardcoreMode = true;
    }
}
