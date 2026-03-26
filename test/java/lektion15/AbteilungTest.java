package lektion15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbteilungTest {

    @Test
    public void testGehalsberechnungUndBefoerderung(){

        Angestellter angestellter = new Angestellter("Müller", "Max", "NR13", 2000.0, "10.10.2000");
        Abteilungsleiter abteilungsleiter = new Abteilungsleiter("Stephan", "Ludi", "NR12", 3000.0, "12.08.1990");

        //TExt falls fehler
        assertEquals(2000.0, angestellter.berechneGehalt(), 0.001, "Gehalt des Angestellten vor Beförderung stimmt nicht!");
        assertEquals(6000.0, abteilungsleiter.berechneGehalt(), 0.001, "Gehalt des Leiters stimmt nicht!" );

        abteilungsleiter.befoerdern(angestellter);
        assertEquals(2200.0, angestellter.berechneGehalt(), 0.001, "Gehalt nach beförderung stimmt nicht!");


    }
}
