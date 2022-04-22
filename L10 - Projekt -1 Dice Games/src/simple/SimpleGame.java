package simple;

import java.util.Scanner;

public class SimpleGame {

    /**
     * Simulates playing one game of Simple.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();

        boolean finished = false;
        while (!finished) {
            // TODO: Roll dice, print roll description.
            thrower.roll();
            System.out.println(thrower.rollDescription());

            System.out.println("Roll again? (Y/n) ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                finished = true;
            }
        }
        scanner.close();

        System.out.printf("\nResults:\n");
        System.out.printf("---------\n");
        // TODO: Print all the results:
        // roll count, total of all face values, average sum in one roll,
        System.out.printf("Roll count: %6d%n", thrower.getRollCount());
        System.out.printf("Total: %11d%n", thrower.getAllFaceValues());
        double avrg = (double)thrower.getSumOfOneRoll()/(double)thrower.getRollCount();
        System.out.printf("Average sum: %11f%n", avrg);
        // count of face value 6, count of same face value on both dice,
        System.out.printf("Rolled 6: %7d%n", thrower.getCountOFV6());
        System.out.printf("Same roll: %6d%n", thrower.getCountOFVBothDice());
        // max sum in one roll.
        System.out.printf("Max roll: %7d%n", thrower.getSumOfOneRoll());
        // Use the method: System.out.printf().

    }

    /**
     * Prints the rules of Simple.
     */
    public void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Simple:");
        System.out.println("The player throws the 2 dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

}
