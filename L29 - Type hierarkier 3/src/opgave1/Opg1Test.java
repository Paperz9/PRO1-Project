package opgave1;

public class Opg1Test {
    public static void main(String[] args) {
        Chili chilies[] = {
                new Chili("Banana Pepper", 1000),
                new Chili("Serrano Pepper", 15000)
        };

        System.out.println(average(chilies));
        System.out.println(max(chilies));

        Beer beers[] = {
                new Beer("Tuborg Classic", 4.6),
                new Beer("Carlsberg", 4.3),
                new Beer("Elefant Øl", 7.5)
        };

        Measurable[] blackFriday = blackFridayMeal(chilies, beers);
        System.out.println();
        System.out.printf("Strongest chili: %.2f\n", blackFriday[0].getMeasure());
        System.out.printf("Strongest beer: %.2f\n", blackFriday[1].getMeasure());
    }

    public static double average(Measurable[] objects) {
        double sum = 0;
        int count = 0;
        for (Measurable e : objects) {
            if (e instanceof Chili) {
                sum += e.getMeasure();
                count++;
            }
            else {
                sum += e.getMeasure();
                count++;
            }
        }
        return sum / count;
    }

    public static Measurable max(Measurable[] objects) {
        Measurable max = objects[0];
        for (Measurable e : objects) {
            if (e.getMeasure() > max.getMeasure()) {
                max = e;
            }
        }
        return max;
    }

    public static Measurable[] blackFridayMeal(Measurable[] chilies, Measurable[] beers) {
        Measurable[] stronk = {max(chilies), max(beers)};
        return stronk;
    }
}
