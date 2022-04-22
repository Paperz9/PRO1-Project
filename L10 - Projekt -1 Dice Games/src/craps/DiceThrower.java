package craps;


public class DiceThrower {
    // 2 dice with face count of 6 each
    private Die die1, die2;

    public DiceThrower() {
        // TODO: Make a constructor that initialises all fields.
        die1 = new Die();
        die2 = new Die();
    }
    // TODO: Add get methods for the fields.


    /**
     * Rolls the 2 dice.
     */
    public void roll() {
        // TODO: Roll the 2 dice.
        die1.roll();
        die2.roll();
        System.out.println(rollDescription());
    }

    public int sum() {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    /**
     * Returns a textual description of the roll of the 2 dice.
     * Example: Returns "(4,5)" for a roll of 4 and 5.
     */
    public String rollDescription() {
        // TODO: Use the method: String.format().
        String descript = String.format("(%d, %d) Sum af dit kast: %d", die1.getFaceValue(), die2.getFaceValue(), sum());
        return descript;
    }

}
