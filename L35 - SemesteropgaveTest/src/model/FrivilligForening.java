package model;

public class FrivilligForening extends Frivillig{
    private String unionName;
    private int amountOfMembers;

    public FrivilligForening(String name, String phoneNumber,
                             int maxAmountOfHours, String unionName, int amountOfMembers) {
        super(name, phoneNumber, maxAmountOfHours);
        this.unionName = unionName;
        this.amountOfMembers = amountOfMembers;
    }

    public String toString() {
        return super.toString() + "\n" +
                "Forenings navn: " + unionName + "\n" +
                "Antal medlemmer: " + amountOfMembers;
    }
}
