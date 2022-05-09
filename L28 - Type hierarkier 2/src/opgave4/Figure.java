package opgave4;

public abstract class Figure {
    private int xPos;
    private int yPos;

    public Figure(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public abstract double area();

    public void moveXPos(int moveXPos) {
        this.xPos += xPos;
    }

    public void moveYPos(int moveYPos) {
        this.yPos += yPos;
    }

    @Override
    public String toString() {
        String s = String.format("(%d,%d)", xPos, yPos);
        return s;
    }
}
