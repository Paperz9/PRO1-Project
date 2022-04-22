package opgave1;

import java.util.Arrays;

public class opg1 {
    public static void main(String[] args) {
        // 1.a
        int[] ar1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // 1.b
        int[] ar2 = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};

        // 1.c
        int[] ar3 = new int[10];
        for (int i = 0; i < 10; i++) {
            ar3[i] = i;
        }

        // 1.d
        int[] ar4 = new int[10];
        for (int i = 0; i < 10; i++) {
            ar4[i] = 2 * i + 2;
        }

        // 1.e
        int[] ar5 = new int[10];
        for (int i = 0; i < 10; i++) {
            ar5[i] = (1 + i) * (i + 1);
        }

        // 1.f
        int[] ar6 = new int[10];
        for (int i = 0; i < 10; i++) {
           if (i % 2 == 0) {
               ar6[i] = 0;
           }
           else {
               ar6[i] = 1;
           }
        }

        // 1.g
        int[] ar7 = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                ar7[i] = i;
            }
            else {
                ar7[i] = i - 5;
            }
        }

        // 1.h
        int[] ar8 = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                ar8[i] = i * 2;
            }
            else {
                ar8[i] = 2 * i + 1;
            }
        }




        System.out.println("1.a: " + Arrays.toString(ar1));
        System.out.println("1.b: " + Arrays.toString(ar2));
        System.out.println("1.c: " + Arrays.toString(ar3));
        System.out.println("1.d: " + Arrays.toString(ar4));
        System.out.println("1.e: " + Arrays.toString(ar5));
        System.out.println("1.f: " + Arrays.toString(ar6));
        System.out.println("1.g: " + Arrays.toString(ar7));
        System.out.println("1.h: " + Arrays.toString(ar8));
    }
}
