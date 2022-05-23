package opgave;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        String fileName = "L32 - Filer og Exceptions/src/opgave/Opgave1Numbers.txt";
        File in = new File(fileName);
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                int num = scanner.nextInt();
                numberList.add(num);
            }
            Collections.reverse(numberList);
            System.out.println(numberList);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            ex.printStackTrace();
        }
    }
}
