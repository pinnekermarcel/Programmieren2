package lektion22.visitor;

public class Baum<E extends Comparable<E>> {

    public static class Knoten<E> {
        Knoten<E> left;
        Knoten<E> right;
        E content;
    }

    Knoten<E> root;

    public void einfuegen(E content) {}

    protected void traversiere(Visitor<E> visitor) {
        if (root == null) return;
        else traversiere(root, visitor);
    }

    protected void traversiere(Knoten<E> current, Visitor<E> visitor) {
        if (current.left != null) traversiere(current.left, visitor);
        visitor.visit(current); // Hier wird dein Visitor aufgerufen!
        if (current.right != null) traversiere(current.right, visitor);
    }

    public int size() {
        // Visitor instanziieren
        SizeVisitor<E> meinVisitor = new SizeVisitor<>();

        // Visitor auf die Reise durch den Baum schicken
        this.traversiere(meinVisitor);

        // gezählte Ergebnis abfragen und zurückgeben
        return meinVisitor.getCount();
    }
}