package opgave2;

import java.util.Arrays;

public class Opg2 {
    public static void main(String[] args) {

        int[] list1 = {2,4,6,8,10,12,14};
        int[] list2 = {1,2,4,5,6,9,12,17};

        System.out.println(Arrays.toString(sharedNumbers(list1, list2)));
    }
    /**
     * Return a sorted array containing all elements
     * shared by l1 and l2.
     * The returned array must have no empty entries.
     * Pre: l1 and l2 are sorted and have no empty entries.
     */
    public static int[] sharedNumbers (int[] l1, int[] l2) {
        int[] result = new int[l1.length];

        int i1 = 0;
        int i2 = 0;
        int counter = 0;
        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2]) {
                i1++;
            }
            else if (l1[i1] > l2[i2]){
                i2++;
            }
            else {
                result[counter] = l1[i1];
                i1++;
                i2++;
                counter++;
            }
        }
        int[] resultFitted = new int[counter];
        for (int i = 0; i < counter; i++) {
            resultFitted[i] = result[i];
        }
        return resultFitted;
    }
}
