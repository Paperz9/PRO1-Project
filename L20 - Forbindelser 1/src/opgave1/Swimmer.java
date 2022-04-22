package opgave1;

import java.util.ArrayList;
import java.util.Collections;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

    public Swimmer(String name, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        // TODO: implement!
        double fastest = lapTimes.get(0);
        for (double f : lapTimes) {
            if (f < fastest) {
                fastest = f;
            }
        }
        return fastest;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    /** Pre: This swimmer is not connected to a trainingPlan */
    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    /** Pre: This swimmer is connected to a trainingPlan */
    public void removeTrainingPlan() {
        this.trainingPlan = null;
    }

    public int allTrainingHours() {
        return getTrainingPlan().getWeeklyStrengthHours() + getTrainingPlan().getWeeklyWaterHours();
    }
}
