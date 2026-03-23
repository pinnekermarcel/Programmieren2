package lektion14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PersonTest {

    @Test
    void testPerson(){
        Adresse a = new Adresse("Musterstraße", "8a", "74722", "Bch");
        Person p = new Person("Max", "Muster", a );
        assertEquals("Max", p.vorname);
        assertEquals("Musterstraße", p.adresse.strasse);
    }
    @Test
    void testVornameKlein(){
        try{
            Adresse a = new Adresse("Musterstraße", "8a", "74722", "Bch");
            Person p = new Person("max", "Muster", a );
            fail("RuntimeException was expected, Vorname beginnt klein");
        }catch(Exception e){}
    }
    @Test
    void testStrasseKlein(){
        try {
            Adresse a = new Adresse("musterstraße", "8a", "74722", "Bch");
            Person p = new Person("Max", "Muster", a);
            fail("RuntimeException was expected, strasse beginnt klein");
        }catch(Exception e){}
    }
    @Test
    void testOrtKlein(){
        try{
            Adresse a = new Adresse("Musterstraße", "8a", "74722", "bch");
            Person p = new Person("Max", "Muster", a);
            fail("RuntimeException was expected, ort beginnt klein");
        }catch(Exception e){}

    }
    @Test
    void testHausnummerBuchstabe(){
        try{
            Adresse a = new Adresse("Musterstraße", "a", "74722", "Bch");
            Person p = new Person("Max", "Muster", a);
            fail("RuntimeException was expected, hausnummer beginnt mit Buchstabe");
        }catch(Exception e){}
    }

}
