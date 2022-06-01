package model;

public class Vagt {
    private int hours;

    // Composition --> 1 Job
    Job job; // OBS: package visible

    Vagt(int hours) { // OBS: package visible
        this.hours = hours;
    }

    public Job getJob() {
        return job;
    }

    // Association 0..* --> 1 Frivillig
    private Frivillig frivillig;

    public Frivillig getFrivillig() {
        return frivillig;
    }

    /** Pre: This vagt is not connected to a frivilling. */
    public void setFrivillig(Frivillig frivillig) {
        this.frivillig = frivillig;
    }

    /** Pre: This vagt is connected to a frivilling. */
    public void removeFrivillig() {
        this.frivillig = null;
    }
}
