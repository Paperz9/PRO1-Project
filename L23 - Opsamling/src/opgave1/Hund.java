package opgave1;

public class Hund {
    private final String navn;
    private final boolean stamtavle;
    private final int pris;
    private final Race race;

    public Hund(String navn, boolean stamtavle, int pris, Race race) {
        this.navn = navn;
        this.stamtavle = stamtavle;
        this.pris = pris;
        this.race = race;
    }

    public int getPris() {
        return pris;
    }

    public Race getRace() {
        return race;
    }
}
