package lektion19.galgenmann2;

import java.io.Serializable;

public class ServerAntwort implements Serializable {
    private String aktuellerStand;
    private boolean wortErraten;
    private boolean spielBeendet;
    private boolean treffer;

    public ServerAntwort(String aktuellerStand, boolean wortErraten, boolean spielBeendet, boolean treffer) {
        this.aktuellerStand = aktuellerStand;
        this.wortErraten = wortErraten;
        this.spielBeendet = spielBeendet;
        this.treffer = treffer;
    }

    public String getAktuellerStand() {
        return aktuellerStand;
    }

    public boolean isWortErraten() {
        return wortErraten;
    }

    public boolean isSpielBeendet() {
        return spielBeendet;
    }

    public boolean isTreffer() {
        return treffer;
    }
}
