package opgave1;

import java.util.ArrayList;
import java.util.List;

public class Opgave1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of("Kasper", "Ib", "Carsten", "Bob"));
        System.out.println("Unsorted: " + names);
        System.out.println();
        bubbleSort(names);
        System.out.println("Sorted: " + names);
    }

    public static void bubbleSort(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
