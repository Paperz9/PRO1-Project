package PigGame;

public class DiceThrower {
    private Die die = new Die();
    private int sumFV = 0;

    public int getSumFV() {
        return sumFV;
    }

    public void roll(){
        die.roll();
        sumFV = die.getFaceValue();
        rollDescription();
    }

    /**
     * Returns a textual description of the roll of the die.
     */
    public String rollDescription() {
        return String.format("Die roll: (%d)", die.getFaceValue());
    }
}
