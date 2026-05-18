package lektion20;

import lektion20.sms.IllegalTelephoneNumberException;
import lektion20.sms.SmsConverter;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SmsConverterTest {
    @Test
    public void testNormalesWort() throws Exception {
        Map<Character, Character> map = SmsConverter.createKeyMap();

        String result = SmsConverter.translateWord("FAKULTAET", map);
        assertEquals("325858238", result);

    }
    // 2. Test: Kleinbuchstaben übersetzen
    @Test
    public void testKleinbuchstaben() throws Exception {
        Map<Character, Character> map = SmsConverter.createKeyMap();

        String ergebnis = SmsConverter.translateWord("hallo", map);

        assertEquals("42556", ergebnis);
    }
    @Test
    public void testFehlerBeiZahlen() {
        Map<Character, Character> map = SmsConverter.createKeyMap();

        try {
            // Wir versuchen, ein verbotenes Wort zu übersetzen
            SmsConverter.translateWord("TEST1", map);

            fail("Es hätte ein Fehler geworfen werden müssen!");

        } catch (IllegalTelephoneNumberException e) {

        }
    }
}
