package model;

public class ProfSpiller extends Spiller {
    private double kampHonorar;

    public ProfSpiller(String navn, int aargang, double kampHonorar) {
        super(navn, aargang);
        this.kampHonorar = kampHonorar;
    }

    // S3 (6 p)
    public double getKampHonorar() {
        double antalAfbud = 0;
        for (Deltagelse e : getDeltagelse()) {
            if (e.isAfbud()) {
                antalAfbud++;
            }
        }
        return kampHonorar - kampHonorar * antalAfbud / getDeltagelse().size();
    }
}
