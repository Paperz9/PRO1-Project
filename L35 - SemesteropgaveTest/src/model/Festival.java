package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public Festival(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return name + " " + startDate + " " + endDate;
    }

    // Composition --> 0..* Job
    private final ArrayList<Job> jobs = new ArrayList<>();

    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Job createJob(String code, String description, LocalDate date, int hourlyPay, int totalHours) {
        Job job = new Job(code, description, date, hourlyPay, totalHours);
        jobs.add(job);
        return job;
    }

    //------------------------------------------------------------------------------------

    public int budgetteretJobUdgift() {
        int total = 0;
        for (Job e : jobs) {
            total += e.getHourlyPay() * e.getTotalHours();
        }
        return total;
    }
}
