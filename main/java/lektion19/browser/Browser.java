package lektion19.browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Browser {
    //Rückgabetyp optional = "Karton"
    public Optional<URL> back(){
        try{
            //Simulate: fetch last URL from Stack
            URL url = Math.random() < 0.5 ? new URL("http://google.de") : null;
            return Optional.ofNullable(url);
        } catch(MalformedURLException e){
            return Optional.empty();
        }
    }
    public String retrieveSite(URL url){
        //simulate download site:
        System.out.println("Lade Seite: " + url.toString());
        return url.toString();
    }
    public static void main(String[] args){
        System.out.println("Optional back");
        Browser browser = new Browser();

        Optional<URL> backOpt = browser.back();
        //kein null check mehr
        backOpt.ifPresent(url -> browser.retrieveSite(url));
    }
}
