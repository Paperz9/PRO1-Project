package model;

import java.util.ArrayList;

public class Event {
    private String name;
    private boolean open;
    // association --> 0..* Reservation
    private final ArrayList<Reservation> reservations = new ArrayList<>();

    public Event(String name, boolean open) {
        this.name = name;
        this.open = open;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    /** Pre: The Reservations is not connected to a Event. */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /** Pre: The Reservation is connected to this Event. */
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public int totalReservedSeats() {
        int reservedSeats = 0;
        for (Reservation e : reservations) {
            reservedSeats += e.getSeats().size();
        }
        return reservedSeats;
    }

}
