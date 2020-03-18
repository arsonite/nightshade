package game.asset;

import game.asset.core.Asset;

public class Buff extends Asset {
    private String keyword;
    private int value;
    private boolean isDebuff;

    public Buff(String name, String description, String keyword) {
        super(name, description);
        setKeyword(keyword);
    }

    public Buff(String name, String description, String keyword, boolean isDebuff) {
        this(name, description, keyword);
        setDebuff(isDebuff);
    }

    public Buff(String name, String description, int value) {
        super(name, description);
        setValue(value);
    }

    public Buff(String name, String description, int value, boolean isDebuff) {
        this(name, description, value);
        setDebuff(isDebuff);
    }

    /* GETTER */
    public String keyword() { return keyword; }
    public int value() { return value; }
    public boolean isDebuff() { return isDebuff; }

    /* SETTER */
    public void setKeyword(String keyword) { this.keyword = keyword; }
    public void setValue(int value) { this.value = value; }
    public void setDebuff(boolean isDebuff) { this.isDebuff = isDebuff; }
}
