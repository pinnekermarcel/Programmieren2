package lektion16.schach.Cyborg;

import java.util.Random;

public class Cyborg {
    // Komposition: Der Cyborg hat einen menschlichen und einen maschinellen Teil
    private Mensch menschTeil = new Mensch();
    private Roboter roboterTeil = new Roboter();
    private Random rand = new Random();

    // Wir leiten die Tätigkeiten an die entsprechenden Teile weiter
    public void aufladen() { roboterTeil.aufladen(); }
    public void essen() { menschTeil.essen(); }
    public void warten() { roboterTeil.warten(); }
    public void schlafen() { menschTeil.schlafen(); }
    public void arbeiten() {
        menschTeil.arbeiten();
    }

    public Entscheidung entscheide(Gefahr gefahr){
        Entscheidung entscheidungMensch = menschTeil.entscheide(gefahr);
        Entscheidung entscheidungRoboter = roboterTeil.entscheide(gefahr);

        if (entscheidungMensch == entscheidungRoboter) {
            return entscheidungMensch; // Sie sind sich einig
        } else {
            // Zufällige Entscheidung zwischen beiden bei Uneinigkeit (50/50 Chance)
            return rand.nextBoolean() ? entscheidungMensch : entscheidungRoboter;
        }
    }
    // Main-Methode zum Testen der Funktionalität
    public static void main(String[] args) {
        Mensch m = new Mensch();
        Roboter r = new Roboter();
        Cyborg c = new Cyborg();

        Gefahr aktuelleGefahr = Gefahr.GEFAHR_VORNE;

        System.out.println("--- Testlauf: " + aktuelleGefahr + " ---");
        System.out.println("Mensch entscheidet: " + m.entscheide(aktuelleGefahr));
        System.out.println("Roboter entscheidet: " + r.entscheide(aktuelleGefahr));
        System.out.println("Cyborg entscheidet: " + c.entscheide(aktuelleGefahr));
    }
}
