package lektion15;

import lektion14.Strecke;

public class Abteilungsleiter extends Angestellter {

    public Abteilungsleiter(String nachname, String vorname, String identifikator,
                           double grundgehalt, String geburtsdatum){

        super(nachname, vorname, identifikator, grundgehalt, geburtsdatum);
        this.gehaltsfaktor = 2.0;
    }
    public void befoerdern(Angestellter angestellter){
        angestellter.gehaltsfaktor = angestellter.gehaltsfaktor * 1.10;

    }


}
