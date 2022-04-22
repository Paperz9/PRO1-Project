package model;

import java.util.ArrayList;

public class Seat {
    private int nr;
    private static int standardTimePris = 50;
    Section section;


    public Seat(int nr, Section section) {
        this.nr = nr;
        this.section = section;
    }

    public int getSeatNr() {
        return nr;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Plads " + nr + " ," + section;
    }

    // ---------------------------------------------------------------------------------------

    // assoiation --> 0..* Reservation
    final ArrayList<Reservation> reservation = new ArrayList<>(); // OBS: package visible

    public ArrayList<Reservation> getReservation() {
        return new ArrayList<>(reservation);
    }

    // ---------------------------------------------------------------------------------------


    public static int getStandardTimePris() {
        return standardTimePris;
    }

    public static void setStandardTimePris(int standardTimePris) {
        Seat.standardTimePris = standardTimePris;
    }

    public double pris (int hours) {
        double pris = 0;
        if (section == Section.VIP) {
            pris = (1.25 * standardTimePris) * hours;
        }
        else if (section == Section.Kid) {
            pris = (0.20 * standardTimePris - standardTimePris) * hours;
        }
        else if (section == Section.Tournament) {
            pris = (1.10 * standardTimePris) * hours;
        }
        else {
            pris = standardTimePris * hours;
        }
        return pris;
    }
}
