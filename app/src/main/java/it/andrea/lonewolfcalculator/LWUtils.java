package it.andrea.lonewolfcalculator;

public class LWUtils {

    /**
     * public method used for random number with default min=0 and max=9
     *
     * @return random int between 0 and 9
     */
    public static int roll() {
        return roll(1, 10) - 1;
    }

    /**
     * public method used for random number with custom limit as params
     *
     * @param min lower limit
     * @param max upper limit
     * @return random int between given limit
     */
    public static int roll(int min, int max) {
        return (int) Math.floor(min + Math.random() * (max - min + 1));
    }

    /**
     * public method used to convert combat ratio for decodeDmg Y value
     *
     * @param cr actual combat ratio
     * @return converted combat ratio
     */
    public static int convertCombatRatio(int cr) {
        return 6 + ((cr < 0) ? Math.max((int) Math.floor((float) cr / 2), -6) : Math.min((int) Math.round((float) cr / 2), 6));
    }

    /**
     * static final matrix filled with the official combat result table value (LW1°book)
     * [x][y][z]
     * x = d10 roll value
     * y = converted combat ratio
     * z = 0 enemy, 1 lone wolf
     */
    public static final int decodeDmg[][][] = {
            {{6, 0}, {7, 0}, {8, 0}, {9, 0}, {10, 0}, {11, 0}, {12, 0}, {14, 0}, {16, 0}, {18, 0}, {999, 0}, {999, 0}, {999, 0}}, // 0
            {{0, 999}, {0, 999}, {0, 8}, {0, 6}, {1, 6}, {2, 5}, {3, 5}, {4, 5}, {5, 4}, {6, 4}, {7, 4}, {8, 3}, {9, 3}}, // 1
            {{0, 999}, {0, 8}, {0, 7}, {1, 6}, {2, 5}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 3}, {8, 3}, {9, 3}, {10, 2}}, // 2
            {{0, 8}, {0, 7}, {1, 6}, {2, 5}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 3}, {8, 3}, {9, 2}, {10, 2}, {11, 2}}, // 3
            {{0, 8}, {1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 3}, {8, 2}, {9, 2}, {10, 2}, {11, 2}, {12, 2}}, // 4
            {{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 2}, {9, 2}, {10, 2}, {11, 2}, {12, 2}, {14, 1}}, // 5
            {{2, 6}, {3, 6}, {4, 5}, {5, 4}, {6, 3}, {7, 2}, {8, 2}, {9, 2}, {10, 2}, {11, 1}, {12, 1}, {14, 1}, {16, 1}}, // 6
            {{3, 5}, {4, 5}, {5, 4}, {6, 3}, {7, 2}, {8, 2}, {9, 1}, {10, 1}, {11, 1}, {12, 0}, {14, 0}, {16, 0}, {18, 0}}, // 7
            {{4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}, {9, 1}, {10, 0}, {11, 0}, {12, 0}, {14, 0}, {16, 0}, {18, 0}, {999, 0}}, // 8
            {{5, 3}, {6, 3}, {7, 2}, {8, 0}, {9, 0}, {10, 0}, {11, 0}, {12, 0}, {14, 0}, {16, 0}, {18, 0}, {999, 0}, {999, 0}} // 9
    };
}
