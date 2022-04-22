package opgave1d;

import java.util.ArrayList;

public class Dog {
    private int number;
    private String name;

    public Dog(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name;
    }


    //-----------------------------------------------------------------

    // association 0..* --> 0..1 Person
    final ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }
}
