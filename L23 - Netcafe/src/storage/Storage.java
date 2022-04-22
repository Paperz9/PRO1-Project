package storage;

import model.Reservation;
import model.Seat;
import model.Event;

import java.util.ArrayList;


public class Storage {
    private static final ArrayList<Reservation> reservations = new ArrayList<>();
    private static final ArrayList<Seat> seats = new ArrayList<>();
    private static final ArrayList<Event> events = new ArrayList<>();

    // -----------------------------------------------------------------------------


    public static ArrayList<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    public static void storeReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public static void deleteReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    // -----------------------------------------------------------------------------

    public static ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public static void storeSeats(Seat seat) {
        seats.add(seat);
    }

    public static void deleteSeats(Seat seat) {
        seats.remove(seat);
    }

    // -----------------------------------------------------------------------------

    public static ArrayList<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public static void storeEvents(Event event) {
        events.add(event);
    }

    public static void deleteEvents(Event event) {
        events.remove(event);
    }
}
