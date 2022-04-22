package opgave3;

import java.util.ArrayList;

public class Rental {
    private int no;
    private String date;
    private int days;
    // association --> 1 Car
    private Car car;

    public Rental(int no, String date, int days, Car car) {
        this.no = no;
        this.date = date;
        this.days = days;
        this.car = car;
    }

    public int getNo() {
        return no;
    }

    public String getDate() {
        return date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return car.getPricePerDay() * getDays();
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
