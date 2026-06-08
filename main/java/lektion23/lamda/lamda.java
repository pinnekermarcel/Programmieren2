package lektion23.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class lamda {
    public static void main(String[] args) {
        System.out.println("-- Sort --");
        List<String> woerter = new ArrayList<>(List.of("Bienenschwarm", "Buch", "Blei"));

        woerter.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));

        woerter.forEach(wort -> System.out.println(wort));

        System.out.println("-- Optional --");

        Optional<String> previousSite = Optional.of("http://fhws.de");
        previousSite.ifPresent(site -> System.out.println(site));
    }

}
