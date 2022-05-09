package opgave4;

public class Circle extends Figure {
    private int radius;

    public Circle(int xPos, int yPos, int radius) {
        super(xPos, yPos);
        this.radius = radius;

    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    public String toString() {
        String s = String.format("Circle %s Radius: %d", super.toString(), radius);
        return s;
    }
}
