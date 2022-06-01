package storage;

import model.Festival;
import model.Frivillig;
import model.Job;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Festival> festivals = new ArrayList<>();
    private static final ArrayList<Job> jobs = new ArrayList<>();
    private static final ArrayList<Frivillig> frivillige = new ArrayList<>();


    //---------------------------------------------------------------------

    public static ArrayList<Festival> getFestivals() {
        return new ArrayList<>(festivals);
    }
    public static void storeFestival(Festival festival) {
        festivals.add(festival);
    }

    //---------------------------------------------------------------------

    public static ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public static void storeJob(Job job) {
        jobs.add(job);
    }

    //---------------------------------------------------------------------


    public static ArrayList<Frivillig> getFrivillige() {
        return new ArrayList<>(frivillige);
    }

    public static void storeFrivillige(Frivillig frivillig) {
        frivillige.add(frivillig);
    }
}
