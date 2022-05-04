package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private LocalDate dato;
    Forestilling forestilling; // OBS: package visible

    Order(LocalDate dato, Kunde kunde) { // OBS: package visible
        this.dato = dato;
        this.kunde = kunde;
        kunde.orders.add(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }
// ------------------------------------------------------------------

    private final ArrayList<Seat> seats = new ArrayList<>();

    public ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

// -------------------------------------------------------------------

    // association 0..* --> 1 Kunde
    private Kunde kunde;

    public Kunde getKunde() {
        return kunde;
    }

    /** Pre: This order is not connected to a Kunde. */
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
        kunde.orders.add(this);
    }
}
