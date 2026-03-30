package lektion14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class KugelvolumenTest {
    @Test
    public void testeKugelvolumen() {
        assertEquals(0, Kugelvolumen.berechneKugelvolumen(0.0), 0.001);
        assertEquals(4.189, Kugelvolumen.berechneKugelvolumen(1.0),0.001);
        assertEquals(523.6, Kugelvolumen.berechneKugelvolumen(5.0),0.1);

    }
    @Test
    public void berechneKugelvolumenTestNegativ() {
        try {
            Kugelvolumen.berechneKugelvolumen(-1.0);
            fail("Runtime Exception erwartet");
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            assertEquals("Radius darf nicht negativ sein.", errorMessage);
        }
    }

}
