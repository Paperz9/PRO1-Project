package storage;


import model.Kamp;
import model.Spiller;

import java.util.ArrayList;

// S5 (3 p)
public abstract class Storage {
    private static final ArrayList<Kamp> kampe = new ArrayList<>();
    private static final ArrayList<Spiller> spillere = new ArrayList<>();

    public static ArrayList<Kamp> getKampe() {
        return new ArrayList<>(kampe);
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(spillere);
    }

    public static void storeKamp(Kamp kamp) {
        kampe.add(kamp);
    }

    public static void storeSpiller(Spiller spiller) {
        spillere.add(spiller);
    }
}
