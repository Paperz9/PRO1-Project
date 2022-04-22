package opgave4;

import java.util.ArrayList;
import java.util.Collections;

public class Swimmer {
    private final String name;
    private final ArrayList<Double> lapTimes;

    Swimmer(String name, ArrayList<Double> lapTimes) {
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
        return Collections.min(getLapTimes());
    }

    public int allTrainingHours() {
        return 0;
    }
}
