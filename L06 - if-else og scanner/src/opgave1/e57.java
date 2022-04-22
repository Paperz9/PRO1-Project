package opgave1;

/*
 Write a program that reads three numbers and prints "increasing" if they are in increasing order,
 "decreasing" if they are in decreasing order, and "neither" otherwise. Here,
 "increasing" means "strictly increasing", with each valur larger than its predecessor.
 The sequence 3 4 4 would not be considered increasing.
 */

import java.util.Scanner;

public class e57 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type first integer: ");
        int input1 = scan.nextInt();
        System.out.println("Type 2nd integer: ");
        int input2 = scan.nextInt();
        System.out.println("Type 3rd integer: ");
        int input3 = scan.nextInt();
        if (input1 < input2 && input2 < input3) {
            System.out.println("Numbers are in increasing order");
        }
        else if (input1 > input2 && input2 > input3) {
            System.out.println("Number are in decreasing order");
        }
        else {
            System.out.println("Neither");
        }

        scan.close();
    }
}
