package model;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kamp implements Comparable<Kamp> {
    private String sted;
    private LocalDate dato;
    private LocalTime tid;

    public Kamp(String sted, LocalDate dato, LocalTime tid) {
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    public LocalDate getDato() {
        return dato;
    }

    public String getDatoFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatDate = dato.format(formatter);
        return formatDate;
    }

    public LocalTime getTid() {
        return tid;
    }

    public String getTidFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatTid = tid.format(formatter);
        return formatTid;
    }

    @Override
    public String toString() {
        return sted + " " + dato + " " + tid;
    }

    //----------------------------------------------------------------------

    // aggregation 1 --> 0..* Deltagelse
    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public ArrayList<Deltagelse> getDeltagelse() {
        return new ArrayList<>(deltagelser);
    }

    public Deltagelse opretDeltagelse(boolean afbud, String begrundelse) {
        Deltagelse deltagelse = new Deltagelse(afbud, begrundelse);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    /** Pre: Denne deltagelse er ikke tilknyttet til en kamp. */
    public void addDeltagelse(Deltagelse deltagelse) {
        deltagelser.add(deltagelse);
    }

    /** Pre: Denne deltagelse er tilknyttet til en kamp. */
    public void removeDeltagelse(Deltagelse deltagelse) {
        deltagelser.remove(deltagelse);
    }

    //------------------------------------------------------------------------

    // S4 (5 p)
    public ArrayList<String> afbud() {
        ArrayList<String> list = new ArrayList<>();
        for (Deltagelse deltagelse : deltagelser ) {
            if (deltagelse.isAfbud()) {
                String s = deltagelse.getBegrundelse();
                list.add(s);
            }
        }
        Collections.sort(list);
        return list;
    }

    //------------------------------------------------------------------------

    // S8 (5 point)
    @Override
    public int compareTo(Kamp kamp) {
        int biggest;
        if (dato.compareTo(kamp.getDato()) == 0) {
            if (tid.compareTo(kamp.getTid()) == 0) {
                biggest = sted.compareTo(kamp.getSted());
            }
            else {
                biggest = tid.compareTo(kamp.getTid());
            }
        }
        else {
            biggest = dato.compareTo(kamp.getDato());
        }
        return biggest;
    }

    // S10 (10 p)

    public void spillerHonorar(Kamp kamp, String tekstFil) {
        String fileName = "L36 - Semesteropgaver 2015/src/model/";
        File newFile = new File(fileName + tekstFil + ".txt");
        try (PrintWriter printWriter = new PrintWriter(newFile)) {
            for (Deltagelse d : kamp.deltagelser) {
                if (!d.isAfbud()) {
                    printWriter.println(d.getSpiller().getNavn());
                    printWriter.println("Kamp honorar: " + d.getSpiller().kampHonorar());
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}
