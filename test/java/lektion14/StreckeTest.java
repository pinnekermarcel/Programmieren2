package lektion14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StreckeTest {
    @Test
    public void testStrecke() {
        Strecke s = new Strecke(5,3);
        assertEquals(3, s.a);
        assertEquals(5, s.b);
    }
    @Test
    public void testUeberschneidet() {
        Strecke s = new Strecke(3,6);
        //weit links weit rechts
        assertFalse(s.ueberschneidet(new Strecke(1,1)));
        assertFalse(s.ueberschneidet(new Strecke(7,9)));

        // Nur berühren
        assertFalse(s.ueberschneidet(new Strecke(1, 3)));
        assertFalse(s.ueberschneidet(new Strecke(6,8)));

        //richitge überschnneidung
        assertTrue(s.ueberschneidet(new Strecke(2,4)));
        assertTrue(s.ueberschneidet(new Strecke(4,8)));
        assertTrue(s.ueberschneidet(new Strecke(4,5)));
    }

    @Test
    public void testeToString(){
        Strecke s1 = new Strecke(5,3);
        assertEquals("3--5",s1.toString());
        Strecke s2 = new Strecke(2,8);
        assertEquals("2------8",s2.toString());
        Strecke s3 = new Strecke(4,4);
        assertEquals("4",s3.toString());

    }

}
