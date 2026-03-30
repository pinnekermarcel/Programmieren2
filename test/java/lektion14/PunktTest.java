package lektion14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PunktTest {
    Punkt p = new Punkt();
    @Test
    public void testVerschiebePunkt() {

        p.verschiebePunkt(100, 200);

        assertEquals(100, p.x);
        assertEquals(200, p.y);
    }
    @Test
    public void testVerschiebePunkt2() {
        /*try {
            p.verschiebePunkt(-1, 200);
            fail("RuntimeException expected, x is negative");
        } catch ( RuntimeException e){
            //Message + überprüfen
        }*/
        exceptionHelper(-1, 200, "zielX or zielY is negative");
    }
    @Test
    public void testVerschiebePunkt3() {
        try {
            p.verschiebePunkt(100, -1);
            fail("RuntimeException expected, y is negative");
        } catch ( RuntimeException e){}
    }
    @Test
    public void testVerschiebePunkt4() {
        try {
            p.verschiebePunkt(1930, 100);
            fail("RuntimeException expected, x ist zu groß");
        }  catch ( RuntimeException e){}
    }
    @Test
    public void testVerschiebePunkt5() {
        try {
            p.verschiebePunkt(100, 1090);
            fail("RuntimeException expected, y ist zu groß");
        }catch ( RuntimeException e){}
    }

    public void exceptionHelper(int zielX, int zielY, String message){
        try {
            p.verschiebePunkt(zielX, zielY);
            fail("RuntimeException expected, x is negative");
        } catch ( RuntimeException e){
            //Message + überprüfen
            String errorMessage = e.getMessage();
            assertEquals(message,  errorMessage);
        }
    }
}
