package lektion19;

import lektion19.browser.Browser;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BrowserTest {
    @Test
    public void testBrowser() {
        Browser browser = new Browser();
        Optional<URL> result = browser.back();

        //1. immer ein Optional Object liefern nie null
        assertNotNull(result, "Methode darf nicht null zurückgeben, sondern ein Optional! ");
        //2. Wenn optional nicht leer,prüfen wir den Inhalt
        result.ifPresent(url -> {
            assertEquals("http://google.de", url.toString(), "URL entspricht nicht der vorgabe!");
        });
        }
    }

