package model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private int aargang;

    // associering --> 0..* Deltagelse
    final ArrayList<Deltagelse> deltagelser = new ArrayList<>(); // OBS: package visible

    public Spiller(String navn, int aargang) {
        this.navn = navn;
        this.aargang = aargang;
    }

    public String getNavn() {
        return navn;
    }

    public int getAargang() {
        return aargang;
    }

    @Override
    public String toString() {
        return navn + " " + aargang;
    }

    //--------------------------------------------------------------------------

    public ArrayList<Deltagelse> getDeltagelse() {
        return new ArrayList<>(deltagelser);
    }

    //--------------------------------------------------------------------------

    // S2 (4 p)
    public double kampHonorar() {
        double antalAfbud = 0;
        for (Deltagelse e : getDeltagelse()) {
            if(!e.isAfbud()) {
                antalAfbud++;
            }
        }
        return antalAfbud * 10;
    }
}
