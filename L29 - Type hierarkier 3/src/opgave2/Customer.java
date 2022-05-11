package opgave2;

public class Customer implements Comparable<Customer> {
    private String firstName;
    private String lastName;
    private int age;

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int compareTo(Customer other) {
        return this.lastName.compareTo(other.lastName);
    }
}
