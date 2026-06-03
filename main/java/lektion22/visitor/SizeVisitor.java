package lektion22.visitor;
import lektion22.visitor.Baum.Knoten;

public class SizeVisitor<T> implements Visitor<T> {
    private int count = 0;

    @Override
    public void visit(Baum.Knoten<T> current){
        this.count++;

    }
    public int getCount(){
        return this.count;
    }
}


