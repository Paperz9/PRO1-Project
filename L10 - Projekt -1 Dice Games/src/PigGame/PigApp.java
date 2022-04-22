package PigGame;

public class PigApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pig Game.");

        PigGame game = new PigGame();
        game.printRules();
        System.out.println();

        game.play();

        System.out.println("Thank you for playing Pig Game.");

    }
}
