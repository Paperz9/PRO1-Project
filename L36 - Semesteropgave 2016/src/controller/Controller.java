package controller;

import model.Bane;
import model.Medlem;
import model.Reservation;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

// S5 (4 p)
public class Controller {

    public static Bane opretBane(int nummer, String baneInfo) {
        Bane bane = new Bane(nummer, baneInfo);
        Storage.storeBane(bane);
        return bane;
    }

    public static ArrayList<Bane> getBaner() {
        return Storage.getBaner();
    }

    public static Medlem opretMedlem(String navn, String mobil, String mail) {
        Medlem medlem = new Medlem(navn, mobil, mail);
        Storage.storeMedlem(medlem);
        return medlem;
    }

    public static Reservation opretReservation(LocalDate dato, LocalTime tid, Medlem booker, Medlem makker, Bane bane) {
        Reservation reservation = booker.opretReservation(dato, tid);
        makker.addReservation(reservation);
        bane.addReservation(reservation);
        return reservation;
    }

    public static void initStorage() {
        opretMedlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        opretMedlem("Finn Jensen", "22331144", "fj@msn.com");

        opretBane(1, "Nord/syd vendt");
        opretBane(2, "Under Egetræet");
        opretBane(3, "Med tilskuerpladser");
    }
}
