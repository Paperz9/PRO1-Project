package model;

import java.util.ArrayList;

public class Kunde {
    private String name;
    private String mobil;

    public Kunde(String name, String mobil) {
        this.name = name;
        this.mobil = mobil;
    }

    public String getName() {
        return name;
    }

    public String getMobil() {
        return mobil;
    }

    //  association 1 --> 0..* Order
    final ArrayList<Order> orders = new ArrayList<>(); // OBS: package visible

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }
}
