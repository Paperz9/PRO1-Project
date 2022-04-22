package opgave3;

import java.util.Scanner;

public class CopierApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Copier copier = new Copier();
        System.out.println("Copier has " + copier.getPaperCount() + " paper");
        System.out.println("Enter amount of paper: ");
        int input1 = scan.nextInt();
        copier.insertPaper(input1);
        System.out.println(copier.getPaperCount() + " papers has been inserted into the copier");
        System.out.println("How many copies would you like? ");
        int input2 = scan.nextInt();
        copier.makeCopy(input2);
        System.out.println("Amount of papers left: " + copier.getPaperCount());

        scan.close();
    }
}
