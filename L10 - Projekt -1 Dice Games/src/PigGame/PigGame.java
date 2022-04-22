package PigGame;

import java.util.Scanner;

public class PigGame {
    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");
    private Player playerInTurn = player1;


    public void turn() {
        if (playerInTurn == player1) {
            playerInTurn = player2;
        } else {
            playerInTurn = player1;
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();

        int sum = 0;

        boolean finished = false;
        System.out.println("First roll: " + playerInTurn.getName());

        while (!finished) {
            thrower.roll();
            System.out.println(thrower.rollDescription());

            if (thrower.getSumFV() != 1) {
                sum += thrower.getSumFV();
                System.out.println("sum: " + sum);
                if (playerInTurn.getPoint() + sum >= 100) {
                   printGameWon();
                   break;
                }
                System.out.print("Roll again? (Y/n) ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("n")) {
                    playerInTurn.updateTotal(sum);
                    System.out.println("Total points: " + playerInTurn.getPoint());
                    sum = 0;
                    turn();
                    System.out.println();
                    System.out.println("Currently rolling: " + playerInTurn.getName());
                }
            } else {
                sum = 0;
                turn();
                System.out.println();
                System.out.println(playerInTurn.getName());
                System.out.println("Total points: " + playerInTurn.getPoint());
            }

        }
    }

    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        System.out.println("Congratulation " + playerInTurn.getName() +  " has won");
    }

    public void printRules() {
        System.out.println("=============================================================================================================================================");
        System.out.println("The game is played by two players.");
        System.out.println("The players take turns, throwing one die until he/she throws 1, or until he/she decides to stop throwing. ");
        System.out.println("The player accumulates points (the face value of the die) on each throw, but if he/she throws 1, all points in this turn is lost. ");
        System.out.println("f the player stops before throwing a 1, the points of this turn is added to the points of earlier turns. ");
        System.out.println("The player that reaches 100 points after a turn, is the winner.");
        System.out.println("=============================================================================================================================================");
    }

}
