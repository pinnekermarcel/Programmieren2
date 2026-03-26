package lektion15;

public class Angestellter {
    protected String nachname;
    protected String vorname;
    protected String identifikator;
    protected double grundgehalt;
    protected double gehaltsfaktor;
    protected String geburtsdatum;

    public Angestellter(String nachname, String vorname, String identifikator,
                        double grundgehalt, String geburtsdatum) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.identifikator = identifikator;
        this.grundgehalt = grundgehalt;
        this.geburtsdatum = geburtsdatum;

        this.gehaltsfaktor = 1.0;

    }
    public double berechneGehalt(){
        return this.gehaltsfaktor * this.grundgehalt;
    }
}
