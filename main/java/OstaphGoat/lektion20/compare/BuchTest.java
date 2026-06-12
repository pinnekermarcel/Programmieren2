package OstaphGoat.lektion20.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuchTest {
    public static void main(String[] args) {
        List<Buch> bibliothek = new ArrayList<>();

        bibliothek.add(new Buch("java", 400));
        bibliothek.add(new Buch("der insasse", 250));
        bibliothek.add(new Buch("Love is War", 400));
        bibliothek.add(new Buch("Saitama", 1200));
        bibliothek.add(new Buch("Hobbit", 250));

        System.out.println("--vor der SORTIERUNG--");
        for (Buch b : bibliothek) {
            System.out.println(b);
        }
        Collections.sort(bibliothek);

        System.out.println("--nach der SORTIERUNG--");
        for (Buch b : bibliothek) {
            System.out.println(b);
        }

    }
}
