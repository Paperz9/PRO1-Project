package model;

public class Customer {
    private String name;

    Company company;

    /** Pre: name not empty */
    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Pre: name not empty. */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Company getCompany() {
        return company;
    }
}
