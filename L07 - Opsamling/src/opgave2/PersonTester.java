package opgave2;


public class PersonTester {

    public static void main(String[] args) {
        // Ex. 2
        opgave2.Person p1 = new Person("Ib", 2000, 10, 6);
        p1.printPerson();
        System.out.println(p1.calcAge(7, 10, 2020));
    }
}
