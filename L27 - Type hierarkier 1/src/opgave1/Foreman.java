package opgave1;

public class Foreman extends Mechanic {

    private int registeredYearOfForeman; // The year of elected foreman
    private int appendix; // amount of extra money the foreman get per week.

    public Foreman(String name, String address, int apprenticeshipTest, int hourlyRate,
                   int registeredYearOfForeman, int appendix) {
        super(name, address, apprenticeshipTest, hourlyRate);
        this.registeredYearOfForeman = registeredYearOfForeman;
        this.appendix = appendix;
    }

    public int getRegisteredYearOfForeman() {
        return registeredYearOfForeman;
    }

    public int getAppendix() {
        return appendix;
    }

    @Override
    public double getWeeklySalary() {
        return super.getWeeklySalary() + appendix;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Start år for Foreman: " + registeredYearOfForeman + "\n" +
                "Tilæg: " + appendix;
    }
}
