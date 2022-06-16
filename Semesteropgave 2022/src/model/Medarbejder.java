package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    @Override
    public String toString() {
        return navn + ", Typisk mødetid: " + typiskMødetid;
    }

    //--------------------------------------------------------------------------------------------

    // association 0..* --> 0..* Vagt
    final ArrayList<Vagt> vagter = new ArrayList<>(); // OBS: package visible

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<Vagt>(vagter);
    }

    //--------------------------------------------------------------------------------------------

    // association --> 0..* Funktion
    private final ArrayList<Funktion> funktioner = new ArrayList<>();

    public ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    /** Pre: Denne funktion er ikke tilknyttet denne medarbejder. */
    public void addFunktion(Funktion funktion) {
        funktioner.add(funktion);
    }

    /** Pre: Denne funktion er tilknyttet denne medarbejder. */
    public void removeFunktion(Funktion funktion) {
        funktioner.remove(funktion);
    }
}
