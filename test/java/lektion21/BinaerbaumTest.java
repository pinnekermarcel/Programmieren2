package lektion21;

import lektion21.binaerbaum.Binaerbaum;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaerbaumTest {

    @Test
    public void testSortierung() {
        //neuer Baum
        Binaerbaum<String> baum = new Binaerbaum<>();
        //Elemente einfuegen
        baum.hinzufuegen("Cool");
        baum.hinzufuegen("Aaronson");
        baum.hinzufuegen("Zylla");
        baum.hinzufuegen("Garrett");

        //
        System.out.print("Konsolenausgabe des Baums: ");
        baum.ausgabe();

        List<String> sortierteElemente = getElementsInOrder(baum);

        List<String> erwarteteReihenfolge = List.of("Aaronson", "Cool", "Garrett", "Zylla");
        assertEquals(erwarteteReihenfolge, sortierteElemente, "Die Elemente sollten alphabetisch sortiert im Baum liegen!");
    }
    private <T extends Comparable<T>> List<T> getElementsInOrder(Binaerbaum<T> baum) {
        List<T> liste = new ArrayList<>();
        return liste;
    }

}
