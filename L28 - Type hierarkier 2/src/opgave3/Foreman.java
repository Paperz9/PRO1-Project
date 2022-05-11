package opgave3;

public class Foreman extends Employee {

    private int registeredYearOfForeman; // The year of elected foreman
    private int apprenticeshipTest;
    private int bonus; // amount of extra money the foreman get per week

    public Foreman(String name, String address, int apprenticeshipTest, int hourlyRate,
                   int registeredYearOfForeman, int bonus) {
        super(name, address, hourlyRate);
        this.apprenticeshipTest = apprenticeshipTest;
        this.registeredYearOfForeman = registeredYearOfForeman;
        this.bonus = bonus;
    }

    @Override
    public double getWeeklySalary() {
        return super.getWeeklySalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Start år for Foreman: " + registeredYearOfForeman + "\n" +
                "Tilæg: " + bonus;
    }
}
