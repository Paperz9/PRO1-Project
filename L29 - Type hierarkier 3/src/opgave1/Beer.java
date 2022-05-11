package opgave1;

public class Beer implements Measurable {
    private String name;
    private double alcoholPercentage;

    public Beer(String name, double alcoholPercentage) {
        this.name = name;
        this.alcoholPercentage = alcoholPercentage;
    }

    @Override
    public double getMeasure() {
        return alcoholPercentage;
    }

    @Override
    public String toString() {
        return name + " " + alcoholPercentage;
    }
}
