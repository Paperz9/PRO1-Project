package opgave1;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Kasper", "42069-1337", "69696996");

        Dog dog1 = new Dog(1, "Luftwaffe");
        Dog dog2 = new Dog(2, "Snoopy");

        dog1.setPerson(p1);
        dog2.setPerson(p1);

        System.out.printf("%-6s  %s\n", "Navn", "Ejer");
        for (Dog dogs : p1.dogs) {
            System.out.printf("%-6s  %s\n", dogs.getName(), dogs.getPerson());
        }
    }
}
