package opgave3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Opgave3 {
    public static void main(String[] args) {
        File in = new File("L32 - Filer og Exceptions/src/opgave3/NumbersFile.txt");

        try (PrintWriter writer = new PrintWriter(in)) {
            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0) {
                    writer.println(i);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
    }
}
