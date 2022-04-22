package ex2student;

public class Employee {
    // The first name of the employee.
    private final String first_name;
    // The last name of the employee.
    private final String last_name;
    // This is the age of the employee
    private int age;
    // Whether the employee is a trainee or not.
    private boolean trainee;

    /**
     * Create an employee as a trainee with the given name.
     */
    public Employee(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.trainee = true;
    }

    /**
     * Return the name of the employee.
     */
    public String getFirstName() {
        return first_name;
    }
    public String getLastName() {
        return last_name;
    }
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void birthday() {
        age = age + 1;
    }

    /**
     * Return the trainee state of the employee.
     */
    public boolean isTrainee() {
        return trainee;
    }

    /**
     * Set the trainee state of the employee.
     */
    public void setTrainee(boolean trainee) {
        this.trainee = trainee;
    }

    /**
     * Return a description of the employee (for test purposes).
     */
    @Override
    public String toString() {
        return first_name + " (trainee: " + trainee + ")";
    }

    /**
     * Print a description of the employee.
     */
    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("First name: " + first_name);
        System.out.println("Last name: "  + last_name);
        System.out.println("Trainee: " + trainee);
        System.out.println("Age: " + age);
        System.out.println("*******************");
    }
}
