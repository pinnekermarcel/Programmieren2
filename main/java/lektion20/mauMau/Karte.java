package lektion20.mauMau;

import java.util.Objects;

public class Karte {
    private String farbe;
    private String wert;

    public Karte(String farbe, String wert) {
        this.farbe = farbe;
        this.wert = wert;

    }
    public String getFarbe() {
        return farbe;
    }
    public String getWert() {
        return wert;
    }
    //später ausdrucken auf der Konsole
    @Override
    public String toString() {
        return farbe + " " + wert;
    }
    //doppelte Karten erkennen
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karte karte = (Karte) o;
        return Objects.equals(farbe, karte.farbe) && Objects.equals(wert, karte.wert);
    }
    @Override
    public int hashCode() {
        return Objects.hash(farbe, wert);
    }
}
