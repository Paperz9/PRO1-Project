package PigGame;

public class Player {
    private String name;
    private int point = 0;

    /**
     * Constructor of the class
     */

    public Player(String name){
        this.name = name;
    }

    /**
     * Get name of player
     */

    public String getName() {
        return name;
    }

    /**
     * Get point of the player
     */

    public int getPoint() {
        return point;
    }

    public void updateTotal(int point){
        this.point += point;
    }

}
