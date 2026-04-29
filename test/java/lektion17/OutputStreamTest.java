package lektion17;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OutputStreamTest {
    @Test
    public void testWrtieParamRestrictions() throws IOException {

        try(OutputStream os = new FileOutputStream("test_ausgabe.txt")) {

            byte[] data = new byte[10];
            //Array = null
            assertThrows(NullPointerException.class, () -> {
                os.write(null, 0, 5);
            }, "Ein Null-Array muss eine NUllpointerException werfen. ");
           //Offset = neg.
           assertThrows(IndexOutOfBoundsException.class, () -> {
             os.write(data, -1, 5);
           },"Negativer Offset. ");
           assertThrows(IndexOutOfBoundsException.class, () -> {
               os.write(data, 0, -1);
           }, "neg länge. ");
           assertThrows(IndexOutOfBoundsException.class, () -> {
               os.write(data, 5, 6);
           }, "Offset + Länge überschreiten das Array");
           assertThrows(IndexOutOfBoundsException.class, () -> {
               os.write(data, 15, 2);
           }, "Ein Offset außerhalb des Arrays ");
        }

    }
}

