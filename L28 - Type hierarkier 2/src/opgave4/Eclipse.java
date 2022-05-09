package opgave4;

public class Eclipse extends Figure {
    private int radius1;
    private int radius2;

    public Eclipse(int xPos, int yPos, int radius1, int radius2) {
        super(xPos, yPos);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    @Override
    public double area() {
        return radius1 * radius2 * Math.PI;
    }

    @Override
    public String toString() {
        String s = String.format("Eclipse %s Radius 1: %d Radius 2: %d", super.toString(),
                radius1, radius2);
        return s;
    }
}
