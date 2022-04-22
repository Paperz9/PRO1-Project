package ex2student;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Kasper", "Bryder");
        e1.setAge(29);
        System.out.println("First name: " + e1.getFirstName());
        System.out.println("Last name: " + e1.getLastName());
        System.out.println("Trainee? " + e1.isTrainee());
        System.out.println("Age: " + e1.getAge());
        e1.birthday();
        System.out.println("Birthday: " + e1.getAge());
        System.out.println();

//        e1.setTrainee(false);
        e1.printEmployee();
        System.out.println();
    }
}
