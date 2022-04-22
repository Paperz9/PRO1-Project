package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDateTime startTid;
    private LocalDateTime slutTid;
    // association --> 0..* Seat
    private final ArrayList<Seat> seats = new ArrayList<>();


    public Reservation(LocalDateTime startTid, LocalDateTime slutTid) {
        this.startTid = startTid;
        this.slutTid = slutTid;
    }

    public LocalDateTime getSlutTid() {
        return slutTid;
    }

    public LocalDateTime getStartTid() {
        return startTid;
    }

    // --------------------------------------------------------------------------

    public ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
        seat.reservation.add(this);
    }

    public void removeSeat(Seat seat) {
        seats.remove(seat);
        seat.reservation.remove(seat);
    }
}
