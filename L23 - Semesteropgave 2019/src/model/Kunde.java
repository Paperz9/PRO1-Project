package model;

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
}
