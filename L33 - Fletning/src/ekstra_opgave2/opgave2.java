package ekstra_opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class opgave2 {
    public static void main(String[] args) {
        String file = "L33 - Fletning/src/ekstra_opgave2/personer.txt";
        System.out.println(linFileSearchPerson(file,"Hansen"));
        System.out.println(linFileSearchPerson(file,"Jensen"));
        System.out.println(linFileSearchPerson(file,"Bryder"));
    }

    public static String linFileSearchPerson(String fileName, String target) {
        File in = new File(fileName);
        String result = "";
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                String k = scanner.nextLine();
                String[] parts = k.split(" ");
                if (parts[parts.length - 1].contains(target)) {
                    result = parts[1] + " " + parts[2];
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return result;
    }
}
