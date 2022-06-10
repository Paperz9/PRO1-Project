package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String mobil;
    private String mail;

    public Medlem(String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
    }

    //------------------------------------------------------------------------

    // aggregation -> 0..* Reservation
    private final ArrayList<Reservation> bookerRes = new ArrayList<>();

    private final ArrayList<Reservation> makkerRes = new ArrayList<>();

    public ArrayList<Reservation> getBookerRes() {
        return new ArrayList<>(bookerRes);
    }

    public ArrayList<Reservation> getMakkerRes() {
        return new ArrayList<>(makkerRes);
    }

    public Reservation opretReservation(LocalDate dato, LocalTime startTid) {
        Reservation reservation = new Reservation(dato, startTid);
        bookerRes.add(reservation);
        return reservation;
    }

    /** Pre: Reservation er ikke tilknyttet til dette medlem. */
    public void addReservation(Reservation reservation) {
        makkerRes.add(reservation);
        reservation.medlem = this;
    }

    /** Pre: Reservation er tilknyttet til denne medlem. */
    public void removeReservation(Reservation reservation) {
        bookerRes.remove(reservation);
        reservation.medlem = null;
    }

    //------------------------------------------------------------------------

    public boolean hasAktivReservation() {
        boolean hasReservation = false;
        if (getBookerRes() == null) {
            hasReservation = true;
            System.out.printf("%s har reservation? ", navn);
            getBookerRes();
        }
        System.out.printf("%s har reservation? ", navn);
        getBookerRes();
        return hasReservation;
    }
}
