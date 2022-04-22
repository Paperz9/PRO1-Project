package opgave2;

import java.util.ArrayList;

public class Rental {
    private int number;
    private String date;
    private int days;

    public Rental(int number, String date, int days) {
        this.number = number;
        this.date = date;
        this.days = days;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public int getPrice(Car car) {
        int total = car.getPricePerDay() * getDays();
        return total;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "number=" + number +
                ", date='" + date + '\'' +
                ", days=" + days +
                ", cars=" + cars +
                '}';
    }

    //------------------------------------------------------------------
    // association --> 0..* Car
    private final ArrayList<Car> cars = new ArrayList<>();

    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }

    /** Pre: The car is not connected to this Rental. */
    public void addCar(Car car) {
        cars.add(car);
        car.rentals.add(this);
    }

    /** Pre: The car is connected to this Rental. */
    public void removeCar(Car car) {
        cars.remove(car);
        car.rentals.remove(car);
    }

}
