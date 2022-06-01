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

    /** Pre: Denne deltagelse er ikke tilknyttet til en spiller. */
    public void setSpiller(Spiller spiller) {
        this.spiller = spiller;
        spiller.deltagelser.add(this);
    }

    /** Pre: Denne deltagelse er tilknyttet til en spiller. */
    public void removeSpiller() {
        Spiller spiller = this.spiller;
        this.spiller = null;
        spiller.deltagelser.remove(this);
    }
}
