package opgave4;

public class Person {
    // The persons name
    private final String name;
    // the address of the person
    private String address;
    // the monthly salary of the person
    private int monthlySalary;

    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getMonthlySalary() {
        return this.monthlySalary;
    }
    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    public double getYearlySalary() {
        // the yearly salary plus 2,5% bonus
        return 12 * monthlySalary * 1.025;
    }
}
