package lektion21.binaerbaum;

public class Binaerbaum <T extends Comparable<T>> {
    //Wurzelelement
    private Element<T> root;


    public void hinzufuegen(T wert){
        //Fall 1 der Baum ist Leer
        if(this.root==null){
            this.root = new  Element<>(wert);
        } else {
            hinzufuegenRekursiv(this.root, wert);
        }

    }
    private void hinzufuegenRekursiv(Element<T> aktuellerKnoten, T neuerWert) {
        // Da T "Comparable" erweitert, nutzen wir compareTo für den Vergleich:
        // vergleich < 0 -> neuerWert ist kleiner als aktuellerKnoten.wert
        // vergleich > 0 -> neuerWert ist größer als aktuellerKnoten.wert
        int vergleich = neuerWert.compareTo(aktuellerKnoten.wert);

        if (vergleich < 0) {
            // Der neue Wert ist kleiner -> Wir müssen nach LINKS!
            if (aktuellerKnoten.left == null) {
                // Platz frei! Wir setzen das neue Element hier hin.
                aktuellerKnoten.left = new Element<>(neuerWert);
            } else {
                // Platz besetzt -> Rekursiver Aufruf für das linke Kind
                hinzufuegenRekursiv(aktuellerKnoten.left, neuerWert);
            }
        }
        else if (vergleich > 0) {
            // Der neue Wert ist größer -> Wir müssen nach RECHTS!
            if (aktuellerKnoten.right == null) {
                // Platz frei! Wir setzen das neue Element hier hin.
                aktuellerKnoten.right = new Element<>(neuerWert);
            } else {
                // Platz besetzt -> Rekursiver Aufruf für das rechte Kind
                hinzufuegenRekursiv(aktuellerKnoten.right, neuerWert);
            }
        }
        // Hinweis: Wenn vergleich == 0 ist, existiert der Wert bereits im Baum.
        // In einem Standard-Suchbaum ignorieren wir Duplikate meistens einfach.
    }

    public void ausgabe(){
        ausgabeRekursiv(this.root);
        System.out.println();

    }
    private  void ausgabeRekursiv(Element<T> knoten){
        // Basis-Fall für die Rekursion: Wenn der Knoten null ist, gibt es hier nichts zu tun.
        if (knoten != null) {

            // Schritt 1: Rekursiver Aufruf für das linke Kind
            ausgabeRekursiv(knoten.left);

            // Schritt 2: Den aktuellen Wert ausgeben (mit einem Leerzeichen getrennt)
            System.out.print(knoten.wert + " ");

            // Schritt 3: Rekursiver Aufruf für das rechte Kind
            ausgabeRekursiv(knoten.right);
        }

    }

    private static class Element<T> {
        T wert;
        Element<T> left;
        Element<T> right;

        public Element(T wert) {
            this.wert = wert;
            this.left = null;
            this.right = null;

        }
        public T getWert() { return this.wert; }
        public Element<T> getLeft() { return this.left; }
        public Element<T> getRight() { return this.right; }

    }
    public Element<T> getRoot() {
        return this.root;
    }


}
