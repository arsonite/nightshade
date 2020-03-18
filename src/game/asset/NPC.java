package game.asset;

import game.asset.core.Character;

public class NPC extends Character {
    private boolean essential;

    public NPC(String name, String description) {
        super(name, description);
    }

    /* GETTER */
    public boolean essential() { return essential; }

    /* SETTER */
    public void setEssential(boolean essential) { this.essential = essential; }
}
