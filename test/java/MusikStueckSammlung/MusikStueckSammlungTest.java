package MusikStueckSammlung;

import altklausuren.musikstueksammlung.MusikStueck;
import altklausuren.musikstueksammlung.MusikStuecksammlung;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusikStueckSammlungTest {

    @Test
    public void testSortierung(){
        //Arrange
        MusikStuecksammlung sammlung = new MusikStuecksammlung();
        sammlung.musikStueckEinfuegen(new MusikStueck("Zombies", "The Cranberries", 306));
        sammlung.musikStueckEinfuegen(new MusikStueck("Abba", "ABBA", 180));
        sammlung.musikStueckEinfuegen(new MusikStueck("Thriller", "Michael Jackson", 357));

        //Act & Assert naxh Titel

        List<MusikStueck> sortNachTitel = sammlung.getMusikStueckNachTitel();

        assertEquals("Abba", sortNachTitel.get(0).getTitel());
        assertEquals("Thriller", sortNachTitel.get(1).getTitel());
        assertEquals("Zombies", sortNachTitel.get(2).getTitel());

        //ACT & Assert nach länge
        List<MusikStueck> sortiertNachLaenge = sammlung.getAlleMusikStueckNachLaenge();
        assertEquals(180, sortiertNachLaenge.get(0).getLaenge());
        assertEquals(306, sortiertNachLaenge.get(1).getLaenge());
        assertEquals(357, sortiertNachLaenge.get(2).getLaenge());

    }
}
