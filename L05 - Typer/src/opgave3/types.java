package opgave3;


public class types {

    public static void main(String[] args) {
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";
        // 3.a
        System.out.println(ord1.toUpperCase());
        System.out.println();
        // 3.b
        System.out.println(ord2.toLowerCase());
        System.out.println();
        // 3.c
        System.out.println(ord1 + " " + ord2);
        System.out.println();
        // 3.d
        String ord3 = ord1 + " " + ord2.toLowerCase();
        System.out.println("Ord1 sammensat med ord2: "+ ord3);
        System.out.println();
        // 3.e
        int len = ord3.length();
        System.out.println("Længde på ord3: " + len);
        System.out.println();
        // 3.f
        String ch = ord1.substring(0, 7);
        System.out.println("De 7 først bogstaver i ord1: " + ch);
        System.out.println();
        // 3.g
        String ch1 = ord2.substring(3, 7);
        System.out.println("Bogstave 3 til 7: " + ch1);
        System.out.println();
        // 3.h
        String ch3 = ord3.substring(ord3.lastIndexOf(' '));
        System.out.println("Sidste halvdel af ord3:" + ch3);
    }

}
