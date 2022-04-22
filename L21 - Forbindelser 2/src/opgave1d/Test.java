package opgave1d;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Kasper", "42069-1337", "69696996");

        Dog dog1 = new Dog(1, "Luftwaffe");
        Dog dog2 = new Dog(2, "Snoopy");

//        p1.setDog(dog1);
//        p1.setDog(dog2);

        System.out.printf("%-6s  %s\n", "Navn", "Ejer");
        System.out.printf("%-6s  %s\n", dog1.getName(), dog1.getPersons());
        System.out.printf("%-6s  %s\n", dog2.getName(), dog2.getPersons());
    }
}
