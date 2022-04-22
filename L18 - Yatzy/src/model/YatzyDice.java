package model;

import java.util.Arrays;
import java.util.Random;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6 for i in [0..4]
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private final Random random = new Random();

    /**
     * Return the 5 face values of the dice.
     */
    public int[] getValues() {
        return values;
    }

    /**
     * Set the 5 face values of the dice.<br/>
     * Pre: 1 <= values[i] <= 6 for i in [0..4].<br/>
     * Note: This method is only to be used in tests.
     */
    void setValues(int[] values) {
        this.values = values;
    }

    /**
     * Return the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        return throwCount;
    }

    /**
     * Reset the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }

    /**
     * Roll the 5 dice. Only roll dice that are not hold.<br/>
     * Note: holdStatus[i] is true, if die no. i is hold (for i in [0..4]).
     */
    public void throwDice(boolean[] holdStatus) {
        for (int i = 0; i < values.length; i++) {
            if (!holdStatus[i]) {
                values[i] = random.nextInt(1, 7);
            }
        }
        throwCount++;
    }

    // -------------------------------------------------------------------------

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    private int[] frequency() {
        int [] freq = new int[7];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = countValuesPoints(i);
        }

        return freq;
    }

    /**
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        int same = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {
                same++;
            }
        }
        return same * value;
    }

    public int countValuesPoints(int value) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {
                count++;
            }
        }
        return count;
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        int points = 0;
        int i = 6;
        while (i > 0) {
            if (frequency()[i] >= 2) {
                points = 2 * i;
                return points;
            }
            i--;
        }

        return points;
    }

    /**
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        int pair1 = onePairPoints();
        int pair2 = 0;
        int i = 6;
        while (pair1 != 0 && i > 0) {
            if (frequency()[i] >= 2 && i * 2 != pair1) {
                pair2 = 2 * i;
                return pair1 + pair2;
            }
            i--;
        }

        return 0;
    }

    /**
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        int points = 0;
        int i = 6;
        while (i > 0) {
            if (frequency()[i] >= 3) {
                points = 3 * i;
                return points;
            }
            i--;
        }
        return points;
    }

    /**
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {
        int points = 0;
        int i = 6;
        while (i > 0) {
            if (frequency()[i] >= 4) {
                points = 4 * i;
                return points;
            }
            i--;
        }

        return points;
    }

    /**
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {
        int pair = 0;
        int threes = threeSamePoints();
        int fullHouse = 0;
        int i = 6;
        while (i > 0) {
            if (frequency()[i] == 2) {
                pair = 2 * i;
            }
            i--;
        }
        if (threes > 0 && pair > 0) {
            fullHouse = threes + pair;
        }
        return fullHouse;
    }

    /**
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int points = 0;
        if (Arrays.equals(frequency(), new int[] {0,1,1,1,1,1,0})) {
            points = 15;
        }

        return points;
    }

    /**
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int points = 0;
        if (Arrays.equals(frequency(), new int[] {0,0,1,1,1,1,1})) {
            points = 20;
        }

        return points;
    }

    /**
     * Return points for chance (the sum of face values).
     */
    public int chancePoints() {
        int points = 0;
        for (int face : values) {
            points += face;
        }
        return points;
    }

    /**
     * Return points for yatzy (50 points).<br/>
     * Return 0, if there aren't 5 dice with the same face value.
     */
    public int yatzyPoints() {
        for (int i = 1; i < frequency().length; i++) {
            if (frequency()[i] == 5) {
                return 50;
            }
        }
        return 0;
    }
}
