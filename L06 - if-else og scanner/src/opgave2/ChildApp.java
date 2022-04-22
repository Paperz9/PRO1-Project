package opgave2;

public class ChildApp {
    public static void main(String[] args) {
        Child barn1 = new Child(5, true);
        Child barn2 = new Child(14, false);
        Child barn3 = new Child(18, true);
        System.out.println(barn1.institution());
        System.out.println(barn1.gender());
        System.out.println(barn1.team());
        System.out.println();
        System.out.println(barn2.institution());
        System.out.println(barn2.gender());
        System.out.println(barn2.team());
        System.out.println();
        System.out.println(barn3.institution());
        System.out.println(barn3.gender());
        System.out.println(barn3.team());
    }
}
