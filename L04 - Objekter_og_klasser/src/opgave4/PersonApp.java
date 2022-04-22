package opgave4;

public class PersonApp {

    public static void main(String[] args) {
        Person person = new Person("Kasper");
        person.setAddress("Fuglekærvej 106N");
        person.setMonthlySalary(14000);
        System.out.println("****************************************************");
        System.out.println("* Name: " + person.getName());
        System.out.println("* Address: " + person.getAddress());
        System.out.println("* Monthly salary: " + person.getMonthlySalary());
        System.out.println("* Yearly salary + 2,5% bonus: " + person.getYearlySalary());
        System.out.println("****************************************************");
        System.out.println();

        Person person1 = new Person("Mcloving");
        person1.setAddress("Awesome allé 69");
        person1.setMonthlySalary(420);
        System.out.println("****************************************************");
        System.out.println("* Name: " + person1.getName());
        System.out.println("* Address: " + person1.getAddress());
        System.out.println("* Monthly salary: " + person1.getMonthlySalary());
        System.out.println("* Yearly salary + 2,5% bonus: " + person1.getYearlySalary());
        System.out.println("****************************************************");
 //       person.printPerson();
    }
}
