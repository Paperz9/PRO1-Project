package opgave1d;

import java.util.ArrayList;

public class Person {
    private String name;
    private String cpr;
    private String phone;

    public Person(String name, String cpr, String phone) {
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name;
    }

    //-----------------------------------------------------------------------

    // association 0..1 --> 0..* Dog
    final ArrayList<Dog> dogs = new ArrayList<>();

    /** Note: Nullable return value. */
    public ArrayList<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

//    /** Pre: This person is not connected to a Dog. */
//    public void setDog(Dog dog) {
//        this.dogs = dog;
//        dog.persons.add(this);
//    }

//    /** Pre: This person is connected to a Dog. */
//    public void removeDog() {
//        Dog dog = this.dog;
//        this.dogs = null;
//        dog.persons.remove(this);
//    }
}
