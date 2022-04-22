package controller;

import model.Event;
import model.Reservation;
import model.Seat;
import storage.Storage;
import model.Section;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    /**
     * Create a new Event.
     */
    public static Event createEvent(String name, boolean open) {
        Event event = new Event(name, open);
        Storage.storeEvents(event);
        return event;
    }

    /**
     * Delete the Event.
     */
    public static void deleteEvent(Event event) {
        Storage.deleteEvents(event);
    }

    public static ArrayList<Event> getEvents() {
        return Storage.getEvents();
    }

    // --------------------------------------------------------------------------------

    /**
     * Create a new Reservation.
     */
    public static Reservation createReservation(LocalDateTime startTid, LocalDateTime slutTid) {
        Reservation reservation = new Reservation(startTid, slutTid);
        Storage.storeReservation(reservation);
        return reservation;
    }

    /**
     * Delete the Reservation.
     */
    public static void deleteReservation(Reservation reservation) {
        Storage.deleteReservation(reservation);
    }

    public static ArrayList<Reservation> getReservations() {
        return Storage.getReservations();
    }

    // --------------------------------------------------------------------------------

    /**
     * Create a Seat
     */
    public static Seat createSeat(int nr, Section section) {
        Seat seat = new Seat(nr, section);
        Storage.storeSeats(seat);
        return seat;
    }

    /**
     * Delete the Seat
     */
    public static void deleteSeat(Seat seat) {
        Storage.deleteSeats(seat);
    }

    public static ArrayList<Seat> getSeats() {
        return Storage.getSeats();
    }

    // --------------------------------------------------------------------------------

    /**
     * Add a Seat to the Reservation
     * if the Seat is connected to another Reservation, this connection is removed
     */
    public static void addSeatToReservation(Seat seat, Reservation reservation) {
        reservation.addSeat(seat);
    }

    public static void removeSeatFromReservation(Seat seat, Reservation reservation) {
        reservation.removeSeat(seat);
    }

    // --------------------------------------------------------------------------------

    /**
     * Add a Reservation to a Event
     */
    public static void addReservationToEvent(Reservation reservation, Event event) {
        event.addReservation(reservation);
    }

    public static void removeReservationFromEvent(Reservation reservation, Event event) {
        event.removeReservation(reservation);
    }

    public static void initStorage() {
        Seat nr1 = Controller.createSeat(1, Section.Tournament);
        Seat nr2 = Controller.createSeat(2, Section.Tournament);
        Seat nr3 = Controller.createSeat(3, Section.Standard);
        Seat nr4 = Controller.createSeat(4, Section.Standard);
        Seat nr5 = Controller.createSeat(5, Section.Kid);
        Seat nr6 = Controller.createSeat(6, Section.VIP);

        Event event1 = Controller.createEvent("Dota 2 tournament", true);
        Event event2 = Controller.createEvent("CS GO tournament", false);

        Reservation res1 = Controller.createReservation(LocalDateTime.of(2019,8,12,20,0), LocalDateTime.of(2019,8,12,23,0));
        Controller.addSeatToReservation(nr1, res1);
        Controller.addSeatToReservation(nr2, res1);

        Reservation res2 = Controller.createReservation(LocalDateTime.of(2019,8,13,19,0), LocalDateTime.of(2019,8,14,6,0));
        Controller.addSeatToReservation(nr3, res2);
        Controller.addSeatToReservation(nr4, res2);

        Reservation res3 = Controller.createReservation(LocalDateTime.of(2019,8,14,19,0), LocalDateTime.of(2019,8,15,6,0));
        Controller.addSeatToReservation(nr6, res3);
    }
}
