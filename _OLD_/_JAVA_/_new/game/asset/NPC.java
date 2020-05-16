package game.asset;

import org.apache.commons.codec.binary.Hex;

import game.asset.core.Character;

public class NPC extends Character {
    private boolean essential;

    public NPC(final Hex id, String name, String description) {
        super(id, name, description);
    }

    /* GETTER */
    public boolean essential() { return essential; }

    /* SETTER */
    public void setEssential(boolean essential) { this.essential = essential; }
}
