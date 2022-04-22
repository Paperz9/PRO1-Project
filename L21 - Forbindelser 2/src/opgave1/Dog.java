package opgave1;

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
        return "Dog{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", person=" + person +
                '}';
    }


    //-----------------------------------------------------------------

    // association 0..* --> 0..1 Person
    private Person person;

    /** Note: Nullable return value. */
    public Person getPerson() {
        return person;
    }

    /** Pre: This Dog is not connected to a Person. */
    public void setPerson(Person person) {
        this.person = person;
        person.dogs.add(this);
    }

    /** Pre: This Dog is connected to this person. */
    public void removePerson() {
        Person person = this.person;
        this.person = null;
        person.dogs.remove(this);
    }
}
