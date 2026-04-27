package lektion16;

import lektion16.schach.Brett;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrettTest {
    @Test
    public void testKombiniere() {
        // 1. Arrange: Zwei leere Bretter erstellen
        Brett brett1 = new Brett();
        Brett brett2 = new Brett();

        // Ein paar Felder markieren (Feld 4,4 ist absichtlich auf BEIDEN markiert)
        brett1.markiereFeld(1, 1);
        brett1.markiereFeld(4, 4);

        brett2.markiereFeld(4, 4);
        brett2.markiereFeld(8, 8);

        // 2. Act: Deine neue Methode aufrufen
        Brett kombiniert = brett1.kombiniere(brett2);

        // 3. Assert: Überprüfen, ob das neue Brett die richtigen Felder hat
        assertTrue(kombiniert.gibFeld(1, 1), "Feld (1,1) aus Brett 1 muss markiert sein");
        assertTrue(kombiniert.gibFeld(4, 4), "Die Schnittmenge (4,4) muss markiert sein");
        assertTrue(kombiniert.gibFeld(8, 8), "Feld (8,8) aus Brett 2 muss markiert sein");

        // Zur Sicherheit noch ein leeres Feld prüfen, das wir NICHT markiert haben
        assertFalse(kombiniert.gibFeld(2, 2), "Unmarkiertes Feld (2,2) darf nicht markiert sein");
    }
}
