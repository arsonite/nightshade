package game.asset.util;

public abstract class Asset implements Assets {
	protected String name;
	protected String desc;
	protected final int id;

	public Asset(String name, String desc) {
		this.name = name;
		this.desc = desc;
		id = ID.hash(name, desc);
	}

	public String getName() { return name; }
	public String getDescription() { return desc; }
	public int getID() { return id; }
}