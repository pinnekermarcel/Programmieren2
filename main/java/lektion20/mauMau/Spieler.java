package lektion20.mauMau;

import java.util.HashSet;
import java.util.Set;

public class Spieler {

    //Hand des Spielers; Set verhindert Dublikate
    private Set<Karte> hand = new HashSet<>();
    //zufällige Kartengenerierung[]
    private final String[] FARBEN = {"Kreuz", "Pik", "Herz", "Karo"};
    private final String[] WERTE = {"7","8","9","10", "Bube","Dame", "König","Ass"};
    //Methode um die Hand zu füllen
    public void zieheZufaelligeHand(int anzahlKarten) {
        System.out.println("Ziehe " + anzahlKarten + " zufällige Karten...");
        //Wir ziehen bis zu geg. länge
        while (hand.size() < anzahlKarten) {
            int randomFarbe = (int) (Math.random() * FARBEN.length);
            int randomWert = (int) (Math.random() * WERTE.length);

            Karte gezogeneKarte = new Karte(FARBEN[randomFarbe], WERTE[randomWert]);

            //Karte hinzufügen
            //Bei dublikaten passiert nix
            boolean neuHinzugefuegt = hand.add(gezogeneKarte);
            if (neuHinzugefuegt) {
                System.out.println("Gezogen: " + gezogeneKarte);

            } else {
                System.out.println("Dublikat verhindert! " + gezogeneKarte + " war schon auf der Hand.");
            }
        }
    }
    //methode zum zeigen der Karte
    public void zeigeHand(){
        System.out.println("\n---Aktuelle Hand---");
        java.util.List<Karte> liste = new java.util.ArrayList<>(hand);
        for (int i = 0; i < liste.size(); i++) {

            System.out.println(liste.get(i));
        }
        System.out.println("---\n");
    }

}
