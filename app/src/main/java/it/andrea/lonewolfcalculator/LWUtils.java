package it.andrea.lonewolfcalculator;

public class LWUtils {

    /**
     * public methods used for random number with default min=1 and max=10
     *
     * @return random int between 1 and 10
     */
    public static int roll() {
        return roll(1, 10);
    }

    /**
     * public methods used for random number with custom limit as params
     * @param min lower limit
     * @param max upper limit
     * @return random int between given limit
     */
    public static int roll(int min, int max) {
        return (int) Math.floor(min + Math.random() * (max - min + 1));
    }
}
