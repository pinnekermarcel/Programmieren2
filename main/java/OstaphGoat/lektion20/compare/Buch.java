package OstaphGoat.lektion20.compare;

public class Buch implements Comparable<Buch>{
    String titel;
    int seiten;
    public Buch(String titel, int seiten) {
        this.titel = titel;
        this.seiten = seiten;
    }
    @Override
    public int compareTo(Buch anderesBuch) {
        //nach Seitenzahl absteigend
        int seitenvergleich = Integer.compare(anderesBuch.seiten, seiten);
        if (seitenvergleich != 0){
            return seitenvergleich;
        }
        return titel.compareTo(anderesBuch.titel);
    }
    @Override
    public String toString() {
        return seiten + " Seiten | " +  titel;
    }
}
