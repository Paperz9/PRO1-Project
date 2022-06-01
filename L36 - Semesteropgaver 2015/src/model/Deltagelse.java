package model;

public class Deltagelse {
    private boolean afbud;
    private String begrundelse;

    // associering --> 1 Spiller
    private Spiller spiller;

    public Deltagelse(boolean afbud, String begrundelse) {
        this.afbud = afbud;
        this.begrundelse = begrundelse;
    }

    public boolean isAfbud() {
        return afbud;
    }

    public String getBegrundelse() {
        return begrundelse;
    }

    //-----------------------------------------------------------------

    public Spiller getSpiller() {
        return spiller;
    }

    /** Pre: Denne spiller er ikke knyttet til en anden deltagelse. */
    public void setSpiller(Spiller spiller) {
        this.spiller = spiller;
        spiller.deltagelse.add(this);
    }
}
