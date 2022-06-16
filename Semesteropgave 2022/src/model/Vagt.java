package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public String getFormattedTidFra() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm");
        String formatDate = tidFra.format(formatter);
        return formatDate;
    }

    public String getFormattedTidTil() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm");
        String formatDate = tidTil.format(formatter);
        return formatDate;
    }



    @Override
    public String toString() {
        return navn;
    }

    //-------------------------------------------------------------------------

    // association 0..* --> 0..* Medarbejder
    private final ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

    public ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    /** Pre: Medarbejderen er ikke tilknyttet denne vagt. */
    public void addMedarbejder(Medarbejder medarbejder) {
        medarbejdere.add(medarbejder);
        medarbejder.vagter.add(this);
    }

    /** Pre: Medarbejderen er tilknyttet denne vagt. */
    public void removeMedarbejder(Medarbejder medarbejder) {
        medarbejdere.remove(medarbejder);
        medarbejder.vagter.remove(this);
    }

    //-------------------------------------------------------------------------

    public ArrayList<Antal> antalFunktioner = new ArrayList<>();

    public Antal opretAntalFunktioner(int antal, Funktion funktion) {
        Antal antalFunktion = new Antal(antal, funktion);
        antalFunktioner.add(antalFunktion);
        return antalFunktion;
    }

    //-------------------------------------------------------------------------

    // S2 (5 p)
    public ArrayList<String> findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        ArrayList<String> list = new ArrayList<>();
        for (Medarbejder medarbejder : medarbejdere) {
            if (tidspunkt == medarbejder.getTypiskMødetid()
                    && antalTimer == medarbejder.getAntalTimerPrDag()) {
                String result = medarbejder.toString();
                list.add(result);
            }
        }
        return list;
    }

    //-------------------------------------------------------------------------

    // S3 (5 p)
    public int beregnTimeforbrug() {
        int samletTimeForbrug = 0;
        for (Medarbejder medarbejder : medarbejdere) {
            samletTimeForbrug += medarbejder.getAntalTimerPrDag();
        }
        return samletTimeForbrug;
    }

    //------------------------------------------------------------------------

    // S4 (5 p)
    public int antalMedarbejdereMedFunktion(Funktion funktion) {
        int antal = 0;
        for (Medarbejder medarbejder : medarbejdere) {
            if(funktion.equals(medarbejder.getFunktioner())) {
                antal++;
            }
        }
        return antal;
    }
}
