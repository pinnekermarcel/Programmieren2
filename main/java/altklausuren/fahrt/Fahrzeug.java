package altklausuren.fahrt;

import java.util.ArrayList;
import java.util.List;

public abstract class Fahrzeug {
    protected List<Fahrt> fahrtenbuch;

    public Fahrzeug() {
        //Liste init.
        fahrtenbuch = new ArrayList<Fahrt>();
    }
    public void tragefahrtEin(Fahrt f){
        //fahrt hinzufuegen
        fahrtenbuch.add(f);

    }
    //abstrakte Klasse zwingt jede unterklasse ihr entgelt selber zu berechen
    public abstract double berechneEntgelt(Fahrt f);

}
