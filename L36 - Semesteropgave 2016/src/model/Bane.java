package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private String baneInfo;

    public Bane(int nummer, String baneInfo) {
        this.nummer = nummer;
        this.baneInfo = baneInfo;
    }

    public int getNummer() {
        return nummer;
    }

    //-------------------------------------------------------------------

    // association --> 0..* Reservation
    private final ArrayList<Reservation> reservations = new ArrayList<>();

    public ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    /** Pre: Reservation er ikke tilknyttet til denne bane. */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.bane = this;
    }

    /** Pre: Reservation er tilknyttet til denne bane. */
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.bane = null;
    }

    //-----------------------------------------------------------------------

    // S2 (8 p)
    public boolean isLedig(ArrayList<Reservation> list, LocalDate dato, LocalTime tid) {
        boolean ledig = true;
        int i = 0;
        while (ledig && i < list.size()) {
            Reservation k = list.get(i);
            if (k.getDato() == dato && k.getStartTid() == tid) {
                ledig = false;
            }
            else {
                i++;
            }
        }
        return ledig;
    }

    // S3 (8 p)
    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
       ArrayList<LocalTime> ledigeTider = new ArrayList<>();
       for (Reservation reservation : reservations) {
           if (reservation.getDato() == dato && !ledigeTider.equals(reservation.getStartTid())) {
                   ledigeTider.add(reservation.getStartTid());
               }
           }
       return ledigeTider;
    }
}
