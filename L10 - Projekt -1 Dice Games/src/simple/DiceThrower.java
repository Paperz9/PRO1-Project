package simple;

public class DiceThrower {
	// 2 dice with face count of 6 each
	private Die die1, die2;
	private int rollCount;
	private int allFaceValues;
	private int countOFV6;
	private int countOFVBothDice;
	private int sumOfOneRoll;

	// TODO: Add fields.
	// Fields:
	// 1. The roll count.
	// 2. The total of all face values rolled.
	// 3. The count of face value 6.
	// 4. The count of same face value on both dice.
	// 5. The maximum sum of the face values in one roll.
	// Remember to update fields, when the dice are rolled.

	/**
	 * Creates a DiceThrower object.
	 */
	public DiceThrower() {
		// TODO: Make a constructor that initialises all fields.
		die1 = new Die();
		die2 = new Die();
		this.rollCount = 0;
		this.allFaceValues = 0;
		this.countOFV6 = 0;
		this.countOFVBothDice = 0;
		this.sumOfOneRoll = 0;
	}
	// TODO: Add get methods for the fields.

	public int getRollCount() {
		return rollCount;
	}

	public int getAllFaceValues() {
		return allFaceValues;
	}

	public int getCountOFV6() {
		return countOFV6;
	}

	public int getCountOFVBothDice() {
		return countOFVBothDice;
	}

	public int getSumOfOneRoll() {
		return sumOfOneRoll;
	}


	/**
	 * Rolls the 2 dice.
	 */
	public void roll() {
		// TODO: Roll the 2 dice.
		die1.roll();
		die2.roll();
		int die1Value = die1.getFaceValue();
		int die2Value = die2.getFaceValue();
		allFaceValues += sum();
		if (die1Value == die2Value) {
			countOFVBothDice++;
		}
		if (die2Value == 6) {
			countOFV6++;
		}
		if (die1Value == 6) {
			countOFV6++;
		}
		if (sum()>sumOfOneRoll) {
			sumOfOneRoll = sum();
		}
		rollCount++;

	}

	/**
	 * Returns the sum of the face values in a roll.
	 */
	public int sum() {
		// TODO
		return die1.getFaceValue() + die2.getFaceValue();
	}

	/**
	 * Returns a textual description of the roll of the 2 dice.
	 * Example: Returns "(4,5)" for a roll of 4 and 5.
	 */
	public String rollDescription() {
		// TODO: Use the method: String.format().
		String descript = String.format("(%d, %d)", die1.getFaceValue(), die2.getFaceValue());
		return descript;
	}
}
