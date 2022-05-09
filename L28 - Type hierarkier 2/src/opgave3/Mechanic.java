package opgave3;

public class Mechanic extends Employee {

    private int apprenticeshipTest;

    public Mechanic(String name, String address, int apprenticeshipTest, int hourlyRate) {
        super(name, address, hourlyRate);
        this.apprenticeshipTest = apprenticeshipTest;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Svendeprøve år: " + apprenticeshipTest + "\n" +
                "Timeløn: " + getWeeklySalary();
    }
}
