package opgave1;

public class opg1 {
    public static void main(String[] args) {
        int[][] table = {
                {0, 4, 3, 9, 6},
                {1, 3, 5, 2, 2},
                {3, 3, 1, 0, 1},
                {0, 0, 9, 7, 1},

        };
        print(table);
        System.out.println();
        System.out.printf("%1d%n", getValueAt(table, 2, 3));
        System.out.printf("Sum of row: %1d%n", sumRow(table, 2));
        setValueAt(table, 2, 3, 6);
        System.out.println();
        System.out.printf("New value: %1d%n", getValueAt(table, 2, 3));
        System.out.println("New table");
        print(table);
        System.out.println();
        System.out.printf("Sum of row: %1d%n", sumRow(table, 2));
        System.out.printf("Sum of col: %1d%n", sumColumn(table, 2));
        System.out.printf("Sum of all: %1d", sum(table));

    }

    public static void print(int[][] numbers) {
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.printf("%1d  ", numbers[row][col]);
            }
            System.out.println();
        }
    }

    public static int getValueAt(int[][] numbers, int row, int col) {
        return numbers[row][col];
    }

    public static void setValueAt(int[][] numbers, int row, int col, int value) {
        numbers[row][col] = value;
    }

    public static int sumRow(int[][] numbers, int row) {
        int sum = 0;
        for (int col = 0; col < numbers[row].length; col++)
            sum += numbers[row][col];
            return sum;
    }

    public static int sumColumn(int[][] numbers, int col) {
        int sum = 0;
        for (int row = 0; row < numbers.length; row++)
            sum += numbers[row][col];
            return sum;
    }

    public static int sum(int[][] numbers) {
        int sum = 0;
        for (int row = 0; row < numbers.length; row++)
            for (int col = 0; col < numbers[row].length; col++)
                sum += numbers[row][col];
        return sum;
    }
}
