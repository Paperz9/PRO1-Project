package craps;

import java.util.Scanner;

public class CrapsGame {


    /**
     * Simulates playing one game of craps.
     */
    public void play() {
        // TODO
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();

        thrower.roll();

        int sum = thrower.sum();
        boolean finished = false;
        int points;

        if (sum == 7 || sum == 11) {
            printGameWon();
            finished = true;
        }

        if (sum == 2 || sum == 3 || sum == 12) {
            printGameLost();
            finished = true;
        }

        while (!finished) {
            // TODO: Roll dice, print roll description.
            scanner.nextLine();
            points = sum;
            thrower.roll();
            sum = thrower.sum();
            if (sum == 7) {
                printGameLost();
                finished = true;
            }

            if (points == sum) {
                printGameWon();
                finished = true;
            }
        }
        scanner.close();
    }

    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        // TODO
        System.out.println("You have won the game");
        System.out.println();
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void printGameLost() {
        // TODO
        System.out.println("You have lost the game, better luck next time :)");
        System.out.println();
    }

    /**
     * Prints the rules of craps.
     */
    public void printRules() {
        // TODO
        System.out.println("=============================================================================");
        System.out.println("Rules of Craps:");
        System.out.println("The player throws 2 dice. The first throw is called 'the come out roll'.");
        System.out.println("The player wins, if the sum of the dice in the come out roll is 7 or 11.");
        System.out.println("The player loses, if the sum is 2, 3 or 12.");
        System.out.println();
        System.out.println("    -If the sum is something else, the sum is set as the player's 'point'.");
        System.out.println("    -The player will now continue throwing the dice until he has lost or won.");
        System.out.println("    -A sum equal his 'point' is a win, and a sum equal 7 is a loss.");
        System.out.println("=============================================================================");
    }

}
