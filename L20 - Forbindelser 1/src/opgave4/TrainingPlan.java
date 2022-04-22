package opgave4;

import java.util.ArrayList;

public class TrainingPlan {
    private char level;
    private int weeklyWaterHours;
    private int weeklyStrengthHours;
    private final ArrayList<Swimmer> swimmers = new ArrayList<>();

    public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
        this.level = level;
        this.weeklyWaterHours = weeklyWaterHours;
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public char getLevel() {
        return level;
    }

    public int getWeeklyStrengthHours() {
        return weeklyStrengthHours;
    }

    public int getWeeklyWaterHours() {
        return weeklyWaterHours;
    }

    public ArrayList<Swimmer> getSwimmers() {
        return new ArrayList<>(swimmers);
    }

    public Swimmer createSwimmer(String name, ArrayList<Double> lapTimes) {
        Swimmer swimmer = new Swimmer(name, lapTimes);
        swimmers.add(swimmer);
        return swimmer;
    }
}
