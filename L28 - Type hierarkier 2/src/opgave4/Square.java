package opgave4;

public class Square extends Figure {
    private int sideLength;

    public Square(int xPos, int yPos, int sideLength) {
        super(xPos, yPos);
        this.sideLength = sideLength;
    }

    @Override
    public double area() {
        return sideLength * sideLength;
    }

    public String toString() {
        String s = String.format("Square %s Side length: %d", super.toString(), sideLength);
        return s;
    }
}
