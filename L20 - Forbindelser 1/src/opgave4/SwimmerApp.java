package opgave4;

import java.util.ArrayList;
import java.util.List;

public class SwimmerApp {

    public static void main(String[] args) {
        TrainingPlan planA = new TrainingPlan('A', 16, 10);

        ArrayList<Double> lapTimesJan = new ArrayList<>();
        lapTimesJan.addAll(List.of(1.02, 1.01, 0.99, 0.98, 1.02, 1.04, 0.99));
        planA.createSwimmer("Jan", lapTimesJan);

        ArrayList<Double> lapTimesBo = new ArrayList<>();
        lapTimesBo.addAll(List.of(1.05, 1.01, 1.04, 1.06, 1.08, 1.04, 1.02));
        planA.createSwimmer("Bo", lapTimesBo);

        ArrayList<Double> lapTimesMikkel = new ArrayList<>();
        lapTimesMikkel.addAll(List.of(1.03, 1.01, 1.02, 1.05, 1.03, 1.06, 1.03));
        planA.createSwimmer("Mikkel", lapTimesMikkel);

        System.out.printf("%-6s  %s\n", "Navn", "Banetider");
        for (Swimmer s : planA.getSwimmers()) {
            System.out.printf("%-6s  %s\n", s.getName(), s.getLapTimes());
        }
    }
}
