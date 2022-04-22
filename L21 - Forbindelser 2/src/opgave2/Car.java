package opgave2;

import java.util.ArrayList;

public class Car {
    private String regNumber;
    private String year;
    private int pricePerDay;

    public Car(String regNumber, String year, int pricePerDay) {
        this.regNumber = regNumber;
        this.year = year;
        this.pricePerDay = pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public String getYear() {
        return year;
    }

    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", year='" + year + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }

    //------------------------------------------------------------------------
    // association --> 0..* Rental
    final ArrayList<Rental> rentals = new ArrayList<>(); // OBS: package visible

    public ArrayList<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }
}
