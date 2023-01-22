package ekstra_opgave1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class opgave1 {
    public static void main(String[] args) {
        String file = "L33 - Fletning/src/ekstra_opgave1/talfil.txt";
        System.out.println(linFileSearch(file,1284));
        System.out.println(linFileSearch(file,100));
    }

    public static boolean linFileSearch(String fileName, int target) {
        File in = new File(fileName);
        boolean found = false;
        try (Scanner scanner = new Scanner(in)) {
            while (!found && scanner.hasNextInt()) {
                int line = scanner.nextInt();
                if (line == target) {
                    found = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Target not found!");
        }
        return found;
    }
}
