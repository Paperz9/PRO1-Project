package opgave1;

import java.util.ArrayList;

public class TestApp {
    public static void main(String[] args) {
        ArrayList<Hund> hunde = new ArrayList<>();

        Hund dog1 = new Hund("Niels", true, 1500, Race.Bokser);
        hunde.add(dog1);

        Hund dog2 = new Hund("Bo", false, 500, Race.Puddel);
        hunde.add(dog2);

        Hund dog3 = new Hund("SixtyNine", true, 4000, Race.Bokser);
        hunde.add(dog3);

        Hund dog4 = new Hund("Lotte", true, 1200, Race.Terrier);
        hunde.add(dog4);

        Hund dog5 = new Hund("Sniffer", false, 600, Race.Puddel);
        hunde.add(dog5);

        System.out.println(samletPris(hunde, Race.Bokser));
        System.out.println(samletPris(hunde, Race.Terrier));
        System.out.println(samletPris(hunde, Race.Puddel));

    }

    public static int samletPris(ArrayList<Hund> hunde, Race race) {
        int sum = 0;
        for (Hund e : hunde) {
            if (e.getRace() == race) {
                sum += e.getPris();
            }
        }
        return sum;
    }
}
