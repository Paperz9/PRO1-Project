package opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Opgave4 {
    public static void main(String[] args) {
        File out = new File("L32 - Filer og Exceptions/src/opgave4/NumberOutput.txt");

        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(out)) {
            System.out.println("Type a number: (end with -1");
            boolean finished = false;
            while (!finished) {
                try {
                    int d = scanner.nextInt();
                    if (d == -1) {
                        finished = true;
                    }
                    else {
                        if (d >= 0) {
                            System.out.println("Typed in: " + d);
                            System.out.println();
                            writer.println(d);
                        }
                        else {
                            System.out.println("You did not enter a positive number");
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Not a positive number!");
                    System.out.println();
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("End of program");
    }
}
