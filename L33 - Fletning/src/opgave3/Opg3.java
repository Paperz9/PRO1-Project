package opgave3;

import java.util.ArrayList;
import java.util.Collections;

public class Opg3 {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer[] badCustomers = new Customer[3];

        Customer c1 = new Customer("Ole", "Olsen");
        Customer c2 = new Customer("Kasper", "Nederen");
        Customer c3 = new Customer("Niels", "Danmark");
        Customer c4 = new Customer("Lars","Larsen");
        Customer c5 = new Customer("Anders", "And");

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        badCustomers[0] = c1;
        badCustomers[1] = c3;
        badCustomers[2] = c4;

        Collections.sort(customers);

    }
    /**
     * Return a sorted ArrayList containing all customers
     * from l1 that are not in l2.
     * Pre: l1 and l2 are sorted and l2 has no empty
     * entries.
     */
    public static ArrayList<Customer> goodCustomers(
            ArrayList<Customer> l1, Customer[] l2) {

        ArrayList<Customer> goodCustomers = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i2 < l2.length) {

        }
        return goodCustomers;
    }
}
