package lektion16;

import lektion16.schach.Cyborg.Cyborg;
import lektion16.schach.Cyborg.Entscheidung;
import lektion16.schach.Cyborg.Gefahr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CyborgTest {
    @Test
    public void testCyborgEntscheidung() {
        Cyborg cyborg = new Cyborg();

        boolean hatKorrektEntschieden = false;
        boolean hatUnentschiedenEntschieden = false;

        // Wir rufen die Methode sehr oft auf, um den Zufall auszugleichen
        for (int i = 0; i < 500; i++) {
            Entscheidung e = cyborg.entscheide(Gefahr.GEFAHR_LINKS);

            // Grundlegende Prüfung: Die Entscheidung MUSS eine von diesen beiden sein
            assertTrue(e == Entscheidung.RECHTS || e == Entscheidung.UNENTSCHIEDEN,
                    "Cyborg hat bei GEFAHR_LINKS völlig falsch reagiert!");

            // Wir merken uns, welche Fälle aufgetreten sind
            if (e == Entscheidung.RECHTS) {
                hatKorrektEntschieden = true;
            } else if (e == Entscheidung.UNENTSCHIEDEN) {
                hatUnentschiedenEntschieden = true;
            }
        }

        // Nach 500 Durchläufen sollten beide möglichen Zweige der Random-Logik
        // (durch den Mensch-Teil und den Disput) mindestens einmal betreten worden sein.
        assertTrue(hatKorrektEntschieden, "Cyborg hat nie korrekt entschieden.");
        assertTrue(hatUnentschiedenEntschieden, "Cyborg war nie unentschieden.");
    }
}
