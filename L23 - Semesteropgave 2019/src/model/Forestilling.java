package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String name;
    private LocalDate startDato;
    private LocalDate slutDato;
    private final ArrayList<Order> orders = new ArrayList<>();

    public Forestilling(String name, LocalDate startDato, LocalDate slutDato) {
        this.name = name;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public Order createOrder(LocalDate dato) {
        Order order = new Order(dato);
        orders.add(order);
        return order;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }
}
