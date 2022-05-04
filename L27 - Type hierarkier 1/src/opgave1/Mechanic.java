package opgave1;

public class Mechanic extends Person {

    private int apprenticeshipTest;
    private int hourlyRate;

    public Mechanic(String name, String address, int apprenticeshipTest, int hourlyRate) {
        super(name, address);
        this.apprenticeshipTest = apprenticeshipTest;
        this.hourlyRate = hourlyRate;
    }

    public int getApprenticeshipTest() {
        return apprenticeshipTest;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public double getWeeklySalary() {
        double sum = 0;
        sum = hourlyRate * 37;
        return sum;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Svendeprøve år: " + apprenticeshipTest + "\n" +
                "Timeløn: " + hourlyRate;
    }
}
