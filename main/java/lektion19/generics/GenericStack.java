package lektion19.generics;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenericStack<E> extends ArrayList<E> {
    public void push(E o) {
        this.add(o);
    }
    public E pop(){
        if(this.size() == 0){
            throw new EmptyStackException();
        }
        return this.remove(this.size() - 1);
    }
}
