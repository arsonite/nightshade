package math;

/**
 * The utility-class {@code Functions} is a collection of mathematical functions and algorithms
 * which finds its uses all over the classes in the engine and its assets.
 *
 * @since JDK 11 ~ <i>2020</i>
 * @author Burak Günaydin <b>{@code (arsonite)}</b>
 */
public class Functions {
    public final static double round(double value) {
        String string = "" + value;
        string = string.replaceAll("^.*.", "").substring(0, 1);
        if(Integer.parseInt(string) >= 5) {
            return Math.round(value);
        } else {
            return Math.floor(value);
        }
    }

    public final static double percentageOfValue(double value, double max) {
        return value * 100 / max;
    }

    public final static double percentageOf100(double percentage, double max) {
        return max * percentage / 100;
    }

    public final static boolean roll(double chance) {
        return Math.random() <= chance;
    }

    public final static boolean randomRoll() {
        return Math.random() <= Math.random();
    }

    public final static int hash(String first, String second) {
        return Integer.parseInt(Integer.toString(Math.abs((first + second).hashCode())).substring(0, 32));
    }
}