import util.SuperReader;

public class Main {
	public static boolean debug;

	public final static void main(String[] args) {
		Main.debug = true;
	}

	public final static void parseConfiguration() {
		SuperReader.xml("./res/dump/demo.xml");
	}
}