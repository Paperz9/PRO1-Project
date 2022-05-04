package opgave1;

import java.util.ArrayList;

public class TestApp {
    public static void main(String[] args) {

        ArrayList<Mechanic> mechanics = new ArrayList<>();
        Mechanic m1 = new Mechanic("Kasper", "fantasivej 34",
                1992, 142);
        Foreman f1 = new Foreman("Ole", "fantasivej 69", 1995,
                150, 2000, 100);
        Survoyer s1 = new Survoyer("Per", "fantasivej 69", 1990,
                175, 9);
        mechanics.add(m1);
        mechanics.add(f1);
        mechanics.add(s1);

        System.out.println("Mechanic: " + m1.getWeeklySalary());
        System.out.println("Foreman: " + f1.getWeeklySalary());
        System.out.println("Survoyer: " + s1.getWeeklySalary());
        System.out.println();
        System.out.println(totalWeeklySalary(mechanics));
    }

    public static double totalWeeklySalary(ArrayList<Mechanic> list) {
        double total = 0;
        for (Mechanic e : list) {
            total += e.getWeeklySalary();
        }
        return total;
    }
}