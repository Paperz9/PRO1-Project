package opgave1;

// Write a program that reads an integer and prints whether it is negative, zero, or positive.

import java.util.Scanner;

public class e51 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type an integer: ");
        int input = scan.nextInt();
        if (input > 0) {
            System.out.println("You typed " + input + ", a positive integer");
        } else if (input == 0) {
            System.out.println("You typed zero");
        } else {
            System.out.println("You typed " + ", a negative integer");
        }

        scan.close();
    }
}
