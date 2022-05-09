package Zipfile;

import java.time.LocalDate;

public class TestApp {
    public static void main(String[] args) {

        // Products
        Product p1 = new Product(1, "Barbie", 50.0);
        Product p2 = new Product(2, "Ken", 40.0);
        Product p3 = new Product(3, "Beyblade", 75.0);
        Product p4 = new Product(4, "Lego", 150.0);
        Product p5 = new Product(5, "LoL", 500.0);

        // Orders
        Order o1 = new Order(1);
        o1.createOrderLine(2, p1);
        o1.createOrderLine(5, p2);

        Order o2 = new Order(2);
        o2.createOrderLine(1,p3);
        o2.createOrderLine(4,p4);

        Order o3 = new Order(3);
        o3.createOrderLine(10,p4);
        o3.createOrderLine(15,p1);

        Order o4 = new Order(4);
        o4.createOrderLine(25,p2);
        o4.createOrderLine(1,p5);

        Order o5 = new Order(5);
        o5.createOrderLine(40,p4);
        o5.createOrderLine(10,p3);

        Order o6 = new Order(6);
        o6.createOrderLine(1,p5);
        o6.createOrderLine(10,p1);

        // Customers
        Customer c1 = new Customer("Kasper",
                LocalDate.of(1992,3, 27));
        c1.addOrder(o1);
        c1.addOrder(o2);




        Customer c2 = new Customer("Per",
                LocalDate.of(1995,6,15));
        c2.addOrder(o3);
        c2.addOrder(o4);
        c2.addOrder(o5);
        c2.addOrder(o6);

        System.out.println("Order price: " + o1.orderPrice());
        System.out.println("Order price: " + o2.orderPrice());
        System.out.println("Total: " + c1.totalBuy());
    }
}
