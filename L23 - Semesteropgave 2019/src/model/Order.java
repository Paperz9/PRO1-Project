package model;

import java.time.LocalDate;

public class Order {
    private LocalDate dato;

    Order(LocalDate dato) { // OBS: package visible
        this.dato = dato;
    }

    public LocalDate getDato() {
        return dato;
    }
}
