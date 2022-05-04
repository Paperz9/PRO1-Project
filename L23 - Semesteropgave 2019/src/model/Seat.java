package model;

public class Seat {
    private int row;
    private int number;
    private int price;

    public Seat(int row, int number, int price, Order order) {
        this.row = row;
        this.number = number;
        this.price = price;
        order.addSeat(this);
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }
}
