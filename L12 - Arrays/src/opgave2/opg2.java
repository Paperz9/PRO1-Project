package opgave2;

public class opg2 {
    public static void main(String[] args) {
        int values[] = {4,6,7,2,3};
        double values1[] = {10.1, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println("Summen er: " + sum(values));
        System.out.println("Summen er: " + sum(values1));
    }

    public static int sum(int[] t) {
        int sum = 0;
        int i;

        for (i = 0; i < t.length; i ++)
            sum += t[i];
        return sum;
    }
    public static double sum(double[] t) {
        double sum = 0;
        int i;

        for (i = 0; i < t.length; i ++)
            sum += t[i];
        return sum;
    }
}
