package lektion20.mauMau;

public class Main {
    public static void main(String[] args) {
        Spieler spieler1 = new Spieler();

        //5 KArten
        spieler1.zieheZufaelligeHand(5);
        spieler1.zeigeHand();
    }
}
