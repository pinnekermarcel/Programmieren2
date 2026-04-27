package lektion16;

import lektion16.schach.Münzautomat.muenzautomat.ChangeCalculator;
import lektion16.schach.Münzautomat.muenzautomat.OptimalChangeCal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptimalChangeCalTest {
    @Test
    public void testGetChange() {
        ChangeCalculator calc = new OptimalChangeCal();

        // Testfall 1: 2 Euro und 88 Cent
        // Soll: 1x 2€, 0x 1€, 1x 50c, 1x 20c, 1x 10c, 1x 5c, 1x 2c, 1x 1c
        // Array-Index: {1c, 2c, 5c, 10c, 20c, 50c, 100c, 200c}
        int[] expected1 = {1, 1, 1, 1, 1, 1, 0, 1};
        assertArrayEquals(expected1, calc.getChange(2, 88), "Stückelung für 2,88 Euro ist falsch.");

        // Testfall 2: 3 Euro und 99 Cent
        // Soll: 1x 2€, 1x 1€, 1x 50c, 2x 20c, 0x 10c, 1x 5c, 2x 2c, 0x 1c
        int[] expected2 = {0, 2, 1, 0, 2, 1, 1, 1};
        assertArrayEquals(expected2, calc.getChange(3, 99), "Stückelung für 3,99 Euro ist falsch.");

        // Testfall 3: 0 Euro und 0 Cent (Randfall)
        // Soll: Überall 0
        int[] expectedZero = {0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expectedZero, calc.getChange(0, 0), "Bei 0 Euro dürfen keine Münzen zurückgegeben werden.");
    }
}
