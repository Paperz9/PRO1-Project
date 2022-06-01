package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


// S6 (7 p)
public abstract class Controller {

    public static Kamp opretKamp(String sted, LocalDate dato, LocalTime tid) {
        Kamp kamp = new Kamp(sted, dato, tid);
        Storage.storeKamp(kamp);
        return kamp;
    }

    public static Deltagelse opretDeltagelse(Spiller spiller, Kamp kamp, boolean afbud, String begrundelse) {
        Deltagelse deltagelse = kamp.opretDeltagelse(afbud,begrundelse);
        deltagelse.setSpiller(spiller);
        return deltagelse;
    }

    public static Spiller opretSpiller(String navn, int aargang) {
        Spiller spiller = new Spiller(navn, aargang);
        Storage.storeSpiller(spiller);
        return spiller;
    }

    public static ProfSpiller opretProfSpiller(String navn, int aargang, double kampHonorar) {
        ProfSpiller profSpiller = new ProfSpiller(navn, aargang, kampHonorar);
        Storage.storeSpiller(profSpiller);
        return profSpiller;
    }

    // S7 (5 p)

    /**
     * Opdaterer sammenhængen mellem spiller og deltagelse så de
     * linker til hinanden
     * Precondition: spiller != null og deltagelse != null
     */
    public static void updateSpillerDeltagelse(Spiller spiller, Deltagelse deltagelse) {
        var oldDeltagelse = spiller.getDeltagelse();
        if (oldDeltagelse != null) {
            deltagelse.removeSpiller();
        }
        deltagelse.setSpiller(spiller);
    }

    // S9 (10 p)
    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
        ArrayList<Kamp> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1).compareTo(list2.get(i2)) < 0) {
                result.add(list1.get(i1));
                i1++;
            }
            else {
                result.add(list2.get(i2));
                i2++;
            }
        }
        while (i1 < list1.size()) {
            result.add(list1.get(i1));
            i1++;
        }
        while (i2 < list2.size()) {
            result.add(list2.get(i2));
            i2++;
        }
        return result;
    }

    //---------------------------------------------------------------------------------------

    public static void initStorage() {
        Kamp kamp1 = opretKamp("Herning",
                LocalDate.of(2015,1,26),
                LocalTime.of(10,30));

        Kamp kamp2 = opretKamp("Ikast",
                LocalDate.of(2015,1,27),
                LocalTime.of(13,30));

        Spiller s1 = opretSpiller("Jane Jensen",1999);
        Spiller s2 = opretSpiller("Lene Hansen",2000);
        Spiller s3 = opretSpiller("Mette Petersen", 1999);
        ProfSpiller ps1 = opretProfSpiller("Sofia Kjeldsen",1999,50);
        ProfSpiller ps2 = opretProfSpiller("Maria Nielsen", 2000,55);

        opretDeltagelse(s1,kamp1,true,"Moster Oda har fødselsdag");
        opretDeltagelse(s1,kamp2,false,"");
        opretDeltagelse(s2,kamp1,false,"");
        opretDeltagelse(s2,kamp2,false,"");
        opretDeltagelse(s3,kamp1,false,"");
        opretDeltagelse(s3,kamp2,false,"");
        opretDeltagelse(ps1,kamp2,true,"Dårlig form");
        opretDeltagelse(ps1,kamp1,false,"");
        opretDeltagelse(ps2,kamp1,false,"");
        opretDeltagelse(ps2,kamp2,false,"");
    }
}
