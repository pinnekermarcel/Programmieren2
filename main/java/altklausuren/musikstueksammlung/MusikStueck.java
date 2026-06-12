package altklausuren.musikstueksammlung;

public class MusikStueck {
    String titel;
    String interpret;
    int laenge;
    public MusikStueck(String titel, String interpret, int laenge) {
        this.titel = titel;
        this.interpret = interpret;
        this.laenge = laenge;
    }
    public String getTitel() {
        return this.titel;
    }
    public int getLaenge() {
        return this.laenge;
    }
    @Override
    public String toString() {
        return titel + " von " +  interpret + " (" + laenge + " lang) " ;
    }
}
