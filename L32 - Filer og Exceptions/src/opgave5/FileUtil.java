package opgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
    private String filePath;

    public FileUtil(String filePath) {
        this.filePath = filePath;
    }

    public int max(String fileName) {
        File in = new File(filePath + "/" + fileName);
        System.out.println(in.getPath());
        int max = 0;
        try (Scanner scanner = new Scanner(in)) {
            max = scanner.nextInt();
            while (scanner.hasNextInt()) {
                int d = scanner.nextInt();
                if (d > max) {
                    max = d;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return max;
    }

    public int min(String fileName) {
        File in = new File(filePath + "/" + fileName);
        int min = 0;
        try (Scanner scanner = new Scanner(in)) {
            min = scanner.nextInt();
            while (scanner.hasNextInt()) {
                int d = scanner.nextInt();
                if (d < min) {
                    min = d;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return min;
    }

    public double average(String fileName) throws IOException {
        File in = new File(filePath + "/" + fileName);
        double sum = 0;
        int count = 0;
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                int d = scanner.nextInt();
                sum += d;
                count++;
            }
        } catch (IOException e) {
            throw new IOException("File not found!");
        }
        return sum / count;
    }
}
