package lektion16.schach.Cyborg;

import java.util.Random;

public class Mensch {
    private Random rand = new Random();

    public void essen(){
        System.out.println("Mensch isst...");
    }
    public void schlafen(){
        System.out.println("Mensch schläft...");
    }
    public void arbeiten(){
        System.out.println("Mensch arbeitet...");
    }
    public Entscheidung entscheide(Gefahr gefahr) {
        // 25% Chance auf UNENTSCHIEDEN
        if (rand.nextInt(100) < 25) {
            return Entscheidung.UNENTSCHIEDEN;
        }
        // Ansonsten korrekte Entscheidung wie der Roboter
        switch (gefahr) {
            case GEFAHR_LINKS:
                return Entscheidung.RECHTS;
            case GEFAHR_RECHTS:
                return Entscheidung.LINKS;
            case GEFAHR_VORNE:
                return Entscheidung.BREMSEN;
            default:
                return Entscheidung.UNENTSCHIEDEN;
        }
    }
}
