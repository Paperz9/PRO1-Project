package opgave1;

public class Chili implements Measurable, Filter {
    private String name;
    private int spiciness;

    public Chili(String name, int spiciness) {
        this.name = name;
        this.spiciness = spiciness;
    }

    @Override
    public double getMeasure() {
        return spiciness;
    }

    @Override
    public boolean accept(Measurable x) {
        return x.getMeasure() > 5000;
    }

    public String toString() {
        return name + " " + spiciness;
    }
}
