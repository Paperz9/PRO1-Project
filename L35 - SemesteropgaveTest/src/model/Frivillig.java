package model;

public class Frivillig {
    private String name;
    private String phoneNumber;
    private int maxAmountOfHours;

    public Frivillig(String name, String phoneNumber, int maxAmountOfHours) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.maxAmountOfHours = maxAmountOfHours;
    }

    public String toString() {
        return "Navn: " + name + "\n" +
                "Maks antal timer: " + maxAmountOfHours;
    }
}
