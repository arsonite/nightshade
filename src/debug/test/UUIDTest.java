package debug.test;

import java.util.Arrays;
import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        String[] randomUUID = randomUUIDString.split("-");

        System.out.println(randomUUIDString);
        System.out.println(Arrays.toString(randomUUID));
    }
}
