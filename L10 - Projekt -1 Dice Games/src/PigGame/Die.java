package PigGame;

import java.util.Random;

public class Die {
    private int facePoint = 6;
    private int faceValue = 0;

    /**
     * Get value of the die
     */

    public int getFaceValue() {
        return faceValue;
    }

    /**
     * Roll the die
     */

    public void roll(){
        Random random = new Random();
        faceValue = random.nextInt(1, facePoint + 1);
    }
}
