package opgave;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave1 {
    public static void main(String[] args) {
        String fileName = "L32 - Filer og Exceptions/src/opgave/Opgave1Numbers.txt";
        File in = new File(fileName);
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                int d = scanner.nextInt() * 2;
                System.out.println(d);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            ex.printStackTrace();
        }
    }
}
