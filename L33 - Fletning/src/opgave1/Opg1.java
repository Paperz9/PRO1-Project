package opgave1;

import java.util.ArrayList;
import java.util.Collections;

public class Opg1 {
    public static void main(String[] args) {
        ArrayList<Customer> customers1 = new ArrayList<>();
        ArrayList<Customer> customers2 = new ArrayList<>();

        Customer c1 = new Customer("Ole", "Olsen");
        Customer c2 = new Customer("Kasper", "Nederen");
        Customer c3 = new Customer("Niels", "Danmark");
        Customer c4 = new Customer("Lars","Larsen");
        Customer c5 = new Customer("Anders", "And");

        customers1.add(c1);
        customers1.add(c2);
        customers1.add(c5);
        customers2.add(c3);
        customers2.add(c4);

        Collections.sort(customers1);
        Collections.sort(customers2);
        System.out.println(mergeAllCustomers(customers1,customers2));
    }

    public static ArrayList<Customer> mergeAllCustomers(
            ArrayList<Customer> l1, ArrayList<Customer> l2) {

        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).compareTo(l2.get(i2)) < 0) {
                result.add(l1.get(i1));
                i1++;
            }
            else {
                result.add(l2.get(i2));
                i2++;
            }
        }
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }
        return result;
    }
}
