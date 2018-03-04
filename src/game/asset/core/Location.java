package game.asset.core;

import game.asset.util.Asset;

import teaType.data.TeaType;

public class Location extends Asset {
	private int size;
	private TeaType<Location> loc;

	public Location(String name, String desc) {
		super(name, desc);
		loc = new TeaType<Location>();
		size = loc.size();
	}

	public Location(String name, String desc, int size) {
		super(name, desc);
		loc = new TeaType<Location>(size);
		this.size = loc.size();
	}
	
	public Location() {
		super("", "");
		loc = new TeaType<Location>();
		size = loc.size();
	}
	
	public Location(int size) {
		super("", "");
		loc = new TeaType<Location>(size);
		this.size = loc.size();
	}
	
	public final void addLocation() {
		
	}
	
	public final void removeLocation() {
		
	}
	
	public final void addSubLocation(Location l) { loc.add(l); }
	
	public final void removeSubLocation(Location l) { loc.remove(l); }
	
	public final void moveCharacter(Character c, int id) {
		
	}
	
	public final void moveEntity() {
		
	}
	
	public final void print() {
		
	}
}