package game.asset.util;

public abstract class Asset implements Assets {
	protected String name, desc;
	protected final int id;

	public Asset(String name, String desc) {
		this.name = name;
		this.desc = desc;
		id = ID.hash(name, desc);
	}
	
	public Asset() {
		name = desc = "";
		id = 0;
	}

	public String getName() { return name; }
	public String getDescription() { return desc; }
	
	public int getID() { return id; }
}