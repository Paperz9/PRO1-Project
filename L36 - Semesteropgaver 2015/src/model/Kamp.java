package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Kamp implements Comparable<Kamp> {
    private String sted;
    private LocalDate dato;
    private LocalTime tid;

    public Kamp(String sted, LocalDate dato, LocalTime tid) {
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    public String getSted() {
        return sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    @Override
    public String toString() {
        return sted + " " + dato + " " + tid;
    }

    //----------------------------------------------------------------------

    // aggregation 1 --> 0..* Deltagelse
    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public ArrayList<Deltagelse> getDeltagelse() {
        return new ArrayList<>(deltagelser);
    }

    public Deltagelse opretDeltagelse(boolean afbud, String begrundelse) {
        Deltagelse deltagelse = new Deltagelse(afbud, begrundelse);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    /** Pre: Denne deltagelse er ikke tilknyttet til en kamp. */
    public void addDeltagelse(Deltagelse deltagelse) {
        deltagelser.add(deltagelse);
    }

    /** Pre: Denne deltagelse er tilknyttet til en kamp. */
    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagelser.remove(deltagelse);
    }

    //------------------------------------------------------------------------

    // S4 (5 p)
    public ArrayList<String> afbud() {
        ArrayList<String> list = new ArrayList<>();
        for (Deltagelse deltagelse : deltagelser ) {
            if (deltagelse.isAfbud()) {
                String s = deltagelse.getBegrundelse();
                list.add(s);
            }
        }
        Collections.sort(list);
        return list;
    }

    //------------------------------------------------------------------------

    // S8 (5 point)
    @Override
    public int compareTo(Kamp kamp) {
        int biggest;
        if (dato.compareTo(kamp.getDato()) == 0) {
            if (tid.compareTo(kamp.getTid()) == 0) {
                biggest = sted.compareTo(kamp.getSted());
            }
            else {
                biggest = tid.compareTo(kamp.getTid());
            }
        }
        else {
            biggest = dato.compareTo(kamp.getDato());
        }
        return biggest;
    }

    // S10 (10 p)

    public void spillerHonorar(String tekstFil) {

    }
}
