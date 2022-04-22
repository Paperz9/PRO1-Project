package opgave3;

public class opg3 {
    public static void main(String[] args) {
        int values[] = {4,6,7,2,3};
        int values1[] = {4,6,8,2,6};
        System.out.println("Summen er: " + sum(values));
        System.out.println("Summen er: " + sum(values1));
    }
    public static int sum(int[] t) {
        int sum = 0;
        int i;

        for (i = 0; i < t.length; i++)
            sum += t[i];
        return sum;
    }

//    public static int[] sumArrays(int[] a, int[] b) {
//        int i;
//        for (i = 0; i < 5; i++) {
//
//        }
//    }
}
