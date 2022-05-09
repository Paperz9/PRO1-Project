package opgave3;

public abstract class Employee {

    private String name;
    private String address;
    private int hourlySalary;

    public Employee(String name, String address, int hourlySalary) {
        this.name = name;
        this.address = address;
        this.hourlySalary = hourlySalary;
    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public String getName() {
        return name;
    }

    public double getWeeklySalary() {
        return hourlySalary * 37;
    }

    @Override
    public String toString() {
        return "Navn: " + name + "\n" +
                "Addresse: " + address;
    }
}
