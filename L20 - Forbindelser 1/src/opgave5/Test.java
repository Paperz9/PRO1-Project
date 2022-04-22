package opgave5;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        // Series cast and name
        ArrayList<String> numbNutsCast = new ArrayList<>();
        numbNutsCast.addAll(List.of("Joey", "Johnny", "Mia", "Beetlejuice"));
        Series numbNuts = new Series("NumbNuts", numbNutsCast);

        // Episode with guest actors
        ArrayList<String> numbNutsGuestActors = new ArrayList<>();
        numbNutsGuestActors.addAll(List.of("Elon", "Ricky", "Peter"));
        numbNuts.createEpisode(1, numbNutsGuestActors, 58);
        numbNuts.createEpisode(2, numbNutsGuestActors, 60);

        for (Episode e : numbNuts.getEpisodes()) {
            System.out.println("------------------------------------------------");
            System.out.println("Series Title: " + numbNuts.getTitle());
            System.out.println("Episode no: " + e.getNumber());
            System.out.println("Cast: " + numbNuts.getCast());
            System.out.println("Guest cast: " + e.getGuestCast());
            System.out.println("Episode length: " + e.getLengthMinutes() + " min");
            System.out.println("------------------------------------------------");
            System.out.println();
        }
        System.out.println(numbNuts.getTitle() + "'s length: " + numbNuts.totalLength() + " min");
    }
}
