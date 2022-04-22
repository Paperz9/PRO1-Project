package opgave5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast;
    private final ArrayList<Episode> episodes = new ArrayList<>();

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public ArrayList<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number, guestActors, lengthMinutes);
        episodes.add(episode);
        return episode;
    }

    public int totalLength() {
        int totalLength = 0;
        for (Episode e : episodes) {
            totalLength += e.getLengthMinutes();
        }
        return totalLength;
    }
}
