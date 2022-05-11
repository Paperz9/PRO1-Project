package opgave3;

import java.util.ArrayList;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>(List.of(
                new Mechanic("Kasper", "fantasivej 34", 1992, 142),
                new Foreman("Ole", "fantasivej 69", 1995, 142, 2000, 100),
                new Survoyer("Per", "fantasivej 69", 1990, 175, 9),
                new WorkingBoy("Niels", "fantasivej 69", 65)));

        totalWeeklySalary(employees);
    }

    public static void totalWeeklySalary(ArrayList<Employee> employees) {
        double sum = 0;
        for (Employee e : employees) {
            System.out.println(e.getName() + " weekly salary: " + e.getWeeklySalary());
            sum += e.getWeeklySalary();
        }
        System.out.println();
        System.out.println("Total weekly payout: " + sum);
    }
}