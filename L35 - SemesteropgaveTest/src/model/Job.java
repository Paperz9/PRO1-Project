package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String code;
    private String description;
    private LocalDate date;
    private int hourlyPay;
    private int totalHours;

    Job(String code, String description, LocalDate date, int hourlyPay, int totalHours) { // OBS: package visible
        this.code = code;
        this.description = description;
        this.date = date;
        this.hourlyPay = hourlyPay;
        this.totalHours = totalHours;
    }

    @Override
    public String toString() {
        return code + " - " + description + " - " + date + " - " + "Timelån: " + hourlyPay + " Antal timer: " + totalHours;
     }

    // Composition --> 0..* Vagt
    private final ArrayList<Vagt> vagter = new ArrayList<>();

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public Vagt createVagt(int hours) {
        Vagt vagt = new Vagt(hours);
        vagter.add(vagt);
        vagt.job = this;
        return vagt;
    }

    public int getHourlyPay() {
        return hourlyPay;
    }

    public int getTotalHours() {
        return totalHours;
    }
}
