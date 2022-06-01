package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    /** Creates a new festival */
    public static Festival createFestival(String name, LocalDate startDate, LocalDate endDate) {
        Festival festival = new Festival(name, startDate, endDate);
        Storage.storeFestival(festival);
        return festival;
    }

    public static ArrayList<Festival> getFestivaler() {
        return Storage.getFestivals();
    }

    /** Creates a new Job at a festival. */
    public static Job createJob(Festival festival, String code, String description, LocalDate date,
                                int hourlyPay, int totalHours) {
        Job job = festival.createJob(code, description, date, hourlyPay, totalHours);
        Storage.storeJob(job);
        return job;
    }

    public static ArrayList<Job> getJobs(Festival festival) {
        return festival.getJobs();
    }

    /** Create a frivillig. */
    public static Frivillig createFrivillig(String name, String phoneNumber, int maxAmountOfHours) {
        Frivillig frivillig = new Frivillig(name, phoneNumber, maxAmountOfHours);
        Storage.storeFrivillige(frivillig);
        return frivillig;
    }

    public static ArrayList<Frivillig> getFrivillige() {
        return Storage.getFrivillige();
    }

    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer) {
        Vagt vagt = job.createVagt(timer);
        vagt.setFrivillig(frivillig);
        return vagt;
    }



    public static void initStorage() {
        Festival festival = createFestival("Northside",
                LocalDate.of(2020, 6, 4),
                LocalDate.of(2020, 6, 6));

        Frivillig f1 = createFrivillig("Jane Jensen", "12345677", 20);
        Frivillig f2 = createFrivillig("Lone Hansen", "78787878", 25);
        Frivillig f3 = createFrivillig("Anders Mikkelsen", "55555555", 10);

        FrivilligForening ff1 = new FrivilligForening("Christian Madsen", "23232323", 100,
                "Erhvervsakademi Aarhus", 40);

        Job job1 = festival.createJob("T1", "Rengøring af toliet",
                LocalDate.of(2020, 6,4),100, 5);
        Job job2 = festival.createJob("T2", "Rengøring af toliet",
                LocalDate.of(2020, 6,4),100, 5);
        Job job3 = festival.createJob("T3", "Rengøring af toliet",
                LocalDate.of(2020, 6,4),100, 5);
        Job job4 = festival.createJob("T4", "Rengøring af toliet",
                LocalDate.of(2020, 6,5),100, 5);
        Job job5 = festival.createJob("T5", "Rengøring af toliet",
                LocalDate.of(2020, 6,5),100, 5);
        Job job6 = festival.createJob("T6", "Rengøring af toliet",
                LocalDate.of(2020, 6,5),100, 5);
        Job job7 = festival.createJob("T7", "Rengøring af toliet",
                LocalDate.of(2020, 6,6),100, 5);
        Job job8 = festival.createJob("T8", "Rengøring af toliet",
                LocalDate.of(2020, 6,6),100, 5);
        Job job9 = festival.createJob("T9", "Rengøring af toliet",
                LocalDate.of(2020, 6,6),100, 5);

        tagVagt(job1, f1,4);
        tagVagt(job2,f1,5);

    }
}
