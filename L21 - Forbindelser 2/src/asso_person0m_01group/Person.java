package asso_person0m_01group;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //-----------------------------------------------------

    // association 0..* --> 0..1 Group
    private Group group; // nullable

    /** Note: Nullable return value. */
    public Group getGroup() {
        return group;
    }

    /** Pre: This person is not connected to a group. */
    public void setGroup(Group group) {
        this.group = group;
        group.persons.add(this);
    }

    /** Pre: This person is connected to a group. */
    public void removeGroup() {
        Group group = this.group;
        this.group = null;
        group.persons.remove(this);
    }
}
