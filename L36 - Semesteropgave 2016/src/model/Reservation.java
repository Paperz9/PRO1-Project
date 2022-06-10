package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation> {
    private LocalDate dato;
    private LocalTime startTid;

    public Reservation(LocalDate dato, LocalTime startTid) {
        this.dato = dato;
        this.startTid = startTid;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    //--------------------------------------------------------------------

    // association --> 1 Medlem
    Medlem medlem; // nullable, OBS: package visible

    public Medlem getMedlem() {
        return medlem;
    }

    //--------------------------------------------------------------------

    // association --> 1 Bane
    Bane bane; // nullable, OBS: package visible

    public Bane getBane() {
        return bane;
    }

    // S8 (5 p)
    @Override
    public int compareTo(Reservation other) {
        int compDato = this.dato.compareTo(other.dato);
        if (compDato != 0)
            return compDato;

        int compTid = this.startTid.compareTo(other.startTid);
        if (compTid != 0)
            return compTid;

        return Integer.compare(this.getBane().getNummer(), other.getBane().getNummer());
    }
}
