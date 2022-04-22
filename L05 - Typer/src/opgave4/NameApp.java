package opgave4;

public class NameApp {
    public static void main(String[] args) {
        Name person1 = new Name("Kasper", "Bergholdt", "Bryder");
        System.out.println();
        System.out.println("*********************************************************");
        System.out.println("Full name: " + person1.getFullName());
        System.out.println();
        System.out.println("User name: " + person1.getUserName());
        System.out.println();
        System.out.println("Initials: " + person1.getInits());
        System.out.println();
        System.out.println("Encrypted initials: " + person1.getCryptoInits(3));
        System.out.println();
        System.out.println("*********************************************************");

        Name person2 = new Name("Bjarne", "Mcloving");
        System.out.println("Full name: " + person2.getFullName());
        System.out.println();
        System.out.println("User name: " + person2.getUserName());
        System.out.println();
        System.out.println("Initials: " + person2.getInits());
        System.out.println();
        System.out.println("Encrypted initials: " + person2.getCryptoInits(5));
        System.out.println("*********************************************************");

    }
}
