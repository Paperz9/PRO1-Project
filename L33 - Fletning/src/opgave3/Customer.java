package opgave3;

public class Customer implements Comparable<Customer> {
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @Override
    public int compareTo(Customer x) {
        if(lastName.compareTo(x.getLastName()) < 0){
            return -1;
        } else if (lastName.compareTo(x.getLastName()) > 0) {
            return 1;
        }
        if(firstName.compareTo(x.getFirstName()) < 0){
            return -1;
        }else if (firstName.compareTo(x.getFirstName()) > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return  "" + firstName + " " + lastName;
    }
}
