package opgave4;

import java.util.ArrayList;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        ArrayList<Figure> figures = new ArrayList<>(List.of(
                new Circle(10, 10, 10),
                new Eclipse(20, 20, 20,10),
                new Square(50, 50, 75),
                new Rectangle(40,40,60,75)
        ));

        figuresToString(figures);
        System.out.println();
        System.out.printf("Total Area: %.2f \n", calcTotalArea(figures));
        parallelShift(figures, 15);
        System.out.println();
        figuresToString(figures);
    }

    public static void figuresToString(ArrayList<Figure> figures) {
        for (Figure e : figures) {
            System.out.println(e.toString());
            System.out.printf("  Area: %.2f \n", e.area());
            System.out.println();
        }
    }

    public static double calcTotalArea(ArrayList<Figure> figures) {
        double sum = 0;
        for (Figure e : figures) {
            sum += e.area();
        }
        return sum;
    }

    public static void parallelShift(ArrayList<Figure> figures, int amount) {
        for (Figure e : figures) {
            e.moveXPos(amount);
            e.moveYPos(amount);
        }
    }
}
