package altklausuren.fahrt;

import java.util.List;

public class Umsatzberechner {
    public double berechneGesamtumsatz(List<Fahrzeug> fahrzeuge){
        double gesamtUmsatz = 0.0;

        //1.Schleife
        for(Fahrzeug fz : fahrzeuge){

            for(Fahrt fahrt : fz.fahrtenbuch){
                gesamtUmsatz += fz.berechneEntgelt(fahrt);
            }
        }
        return gesamtUmsatz;
    }
    public double berechneElektroUmsatz(List<Fahrzeug> fahrzeuge){

        List<Fahrzeug> nurElektro = fahrzeuge.stream()
                .filter(fz -> fz instanceof Elektrofahrzeug)
                .toList();
        return berechneGesamtumsatz(nurElektro);
    }
}
