package lektion16.schach.stack.inheritance;

import java.util.ArrayList;

public class StackKomp implements StackInterface{
    private ArrayList<Object> list = new ArrayList<>();

    @Override
    public void push(Object o) {
        list.add(o);

    }
    @Override
    public Object pop() {
        if(list.size()==0){
            throw new IllegalStateException("empty stack");

        }
        return list.remove(list.size()-1);
    }
}
