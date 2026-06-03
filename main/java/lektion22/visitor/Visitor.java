package lektion22.visitor;
import lektion22.visitor.Baum.Knoten;

public interface Visitor<T>{
    public void visit(Knoten<T> current);

}
