package opgave3;

public class WorkingBoy extends Employee {

    public WorkingBoy(String name, String address, int hourlySalary) {
        super(name, address, hourlySalary);
    }

    @Override
    public double getWeeklySalary() {
        return super.getHourlySalary() * 27;
    }
}
