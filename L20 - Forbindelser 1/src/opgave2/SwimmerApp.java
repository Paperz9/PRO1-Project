package opgave2;

import java.util.ArrayList;
import java.util.List;

public class SwimmerApp {

    public static void main(String[] args) {
        ArrayList<Double> lapTimesJan = new ArrayList<>();
        lapTimesJan.addAll(List.of(1.02, 1.01, 0.99, 0.98, 1.02, 1.04, 0.99));

        Swimmer jan = new Swimmer("Jan", lapTimesJan);

        ArrayList<Double> lapTimesBo = new ArrayList<>();
        lapTimesBo.addAll(List.of(1.05, 1.01, 1.04, 1.06, 1.08, 1.04, 1.02));

        Swimmer bo = new Swimmer("Bo", lapTimesBo);

        ArrayList<Double> lapTimesMikkel = new ArrayList<>();
        lapTimesMikkel.addAll(List.of(1.03, 1.01, 1.02, 1.05, 1.03, 1.06, 1.03));

        Swimmer mikkel = new Swimmer("Mikkel", lapTimesMikkel);

        ArrayList<Swimmer> swimmers = new ArrayList<>();
        swimmers.add(jan);
        swimmers.add(bo);
        swimmers.add(mikkel);

        TrainingPlan planA = new TrainingPlan('A', 16, 10);
        TrainingPlan planB = new TrainingPlan('B', 10, 6);

        planA.addSwimmer(jan);
        planA.addSwimmer(bo);
        planB.addSwimmer(mikkel);

        for (Swimmer s : planA.getSwimmers()) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
            System.out.println("Level: " + planA.getLevel());
            System.out.println("Vandtræning: " + planA.getWeeklyWaterHours());
            System.out.println("Styrketræning: " + planA.getWeeklyStrengthHours());
            System.out.println("Samlet træningstid: " + planA.allTrainingHours());
            System.out.println("--------------------------------------------------------");

        }

        for (Swimmer s : planB.getSwimmers()) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
            System.out.println("Level: " + planB.getLevel());
            System.out.println("Vandtræning: " + planB.getWeeklyWaterHours());
            System.out.println("Styrketræning: " + planB.getWeeklyStrengthHours());
            System.out.println("Samlet træningstid: " + planB.allTrainingHours());
            System.out.println("--------------------------------------------------------");

        }
    }
}
