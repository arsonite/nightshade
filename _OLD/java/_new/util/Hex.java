package util;

import java.util.Arrays;
import java.util.UUID;

public class Hex {
    private final String value;
    private final String[] values;

    public final static String generateID() {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        return randomUUIDString;
    }

    public Hex() {
        this.value = Hex.generateID();
        this.values = this.value.split("-");
    }

    public final int toNumerical() {
        return Integer.parseInt(this.value,16);
    }

    // Getter
    public final String value() { return value; }
    public final String[] values() { return values; }
}
