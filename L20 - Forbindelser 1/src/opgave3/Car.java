package opgave3;

public class Car {
    private String no;
    private String year;
    private int pricePerDay;

    public Car(String no, String year, int pricePerDay) {
        this.no = no;
        this.year = year;
        this.pricePerDay = pricePerDay;
    }

    public void setPricePerDay(int price) {
        this.pricePerDay = price;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public String getNo() {
        return no;
    }

    public String getYear() {
        return year;
    }
}
