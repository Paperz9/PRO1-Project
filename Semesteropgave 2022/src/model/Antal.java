package model;

public class Antal {
    private int antal;
    // association --> 1 Funktion
    private Funktion funktion;
    // Composition --> 1 Vagt
    Vagt vagt; // OBS: package visible


    Antal(int antal, Funktion funktion) { // OBS: package visible
        this.antal = antal;
        this.funktion = funktion;
    }

    public int getAntal() {
        return antal;
    }

    public Funktion getFunktion() {
        return funktion;
    }

    public Vagt getVagt() {
        return vagt;
    }
}
