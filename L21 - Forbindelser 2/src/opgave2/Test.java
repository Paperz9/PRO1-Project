package opgave2;

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car("42069","1999",50);
        Car car2 = new Car("66699", "2001", 75);
        Car car3 = new Car("00001", "0001", 10);

        Rental r1 = new Rental(1, "10-10-2012", 100);
        Rental r2 = new Rental(2, "01-01-2011", 200);

        r1.addCar(car1);
        r1.addCar(car2);
        r2.addCar(car3);

        System.out.println(r1.getCars().toString());
        System.out.println(r1.getPrice(car1));
        System.out.println();

        for (Car c : r1.getCars()) {
            System.out.println(c.toString());
            System.out.println(r1.getPrice(c));
        }
    }
}
