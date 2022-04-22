package opgave3;

import java.util.ArrayList;

public class CarApp {
    public static void main(String[] args) {
        Car car1 = new Car("42069","1999",50);
        Car car2 = new Car("66699", "2001", 75);
        Car car3 = new Car("00001", "0001", 10);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        for (Car c : cars) {
            Rental rental1 = new Rental(1,"05-04-2022", 30, c);
            System.out.println("Car: " + c.getNo() + " " + c.getYear() + " " + c.getPricePerDay());
            System.out.println(rental1.getDays() + " dage koster: " + rental1.getPrice());
            System.out.println();
        }

    }
}
