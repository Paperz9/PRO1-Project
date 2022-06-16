package controller;

import model.Funktion;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Controller {

    // S9 (10 p)
    public static Vagt opretVagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        Vagt vagt = new Vagt(navn, tidFra, tidTil);
        Storage.storeVagt(vagt);
        return vagt;
    }

    public static Medarbejder opretMedarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        Medarbejder medarbejder = new Medarbejder(navn, antalTimerPrDag, typiskMødetid);
        Storage.storeMedarbejder(medarbejder);
        return medarbejder;
    }

    public static Funktion opretFunktion(String navn) {
        Funktion funktion = new Funktion(navn);
        Storage.storeFunktion(funktion);
        return funktion;
    }

    public static void addFunktionTilMedarbejder(Medarbejder medarbejder, Funktion funktion) {
        medarbejder.addFunktion(funktion);
    }

    public static void addMedarbejderTilVagt(Medarbejder medarbejder, Vagt vagt) {
        vagt.addMedarbejder(medarbejder);
    }

    public static void initStorage() {
        Funktion f1 = opretFunktion("Filetering");
        Funktion f2 = opretFunktion("Grøntsager");
        Funktion f3 = opretFunktion("Sovs og tilbehør");
        Funktion f4 = opretFunktion("Buffetopfyldning");

        Medarbejder m1 = opretMedarbejder("Peter", 6, LocalTime.of(8,0));
        Medarbejder m2 = opretMedarbejder("Anne",8, LocalTime.of(8,0));
        Medarbejder m3 = opretMedarbejder("Marie", 6,LocalTime.of(10,0));
        Medarbejder m4 = opretMedarbejder("Torben", 8,LocalTime.of(7,0));

        Vagt vagt1 = opretVagt("Røgede ål til medarbejerne",
                LocalDateTime.of(2022, 6,24,8,0),
                LocalDateTime.of(2022,6,24,12,30));

        vagt1.opretAntalFunktioner(2,f1);
        vagt1.opretAntalFunktioner(1,f2);
        vagt1.opretAntalFunktioner(1,f3);
        vagt1.opretAntalFunktioner(1,f4);

        addMedarbejderTilVagt(m1,vagt1);
        addMedarbejderTilVagt(m2,vagt1);
        addMedarbejderTilVagt(m3,vagt1);

        addFunktionTilMedarbejder(m1,f2);
        addFunktionTilMedarbejder(m1,f3);
        addFunktionTilMedarbejder(m1,f4);
        addFunktionTilMedarbejder(m2,f2);
        addFunktionTilMedarbejder(m2,f3);
        addFunktionTilMedarbejder(m2,f4);
        addFunktionTilMedarbejder(m3,f1);
        addFunktionTilMedarbejder(m3,f2);
        addFunktionTilMedarbejder(m3,f4);
        addFunktionTilMedarbejder(m4,f1);
        addFunktionTilMedarbejder(m4,f3);


        opretVagt("Sommerfest",
                LocalDateTime.of(2022,7,15,10,0),
                LocalDateTime.of(2022,7,15,23,0));
    }
}
