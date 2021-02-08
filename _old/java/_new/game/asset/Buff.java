package game.asset;

import org.apache.commons.codec.binary.Hex;

import game.asset.base.Asset;

public class Buff extends Asset {
    private String keyword;
    private int value;
    private boolean isDebuff;

    public Buff(final Hex id, String name, String description, String keyword) {
        super(id, name, description);
        setKeyword(keyword);
    }

    public Buff(final Hex id, String name, String description, String keyword, boolean isDebuff) {
        this(id, name, description, keyword);
        setDebuff(isDebuff);
    }

    public Buff(final Hex id, String name, String description, int value) {
        super(id, name, description);
        setValue(value);
    }

    public Buff(final Hex id, String name, String description, int value, boolean isDebuff) {
        this(id, name, description, value);
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
