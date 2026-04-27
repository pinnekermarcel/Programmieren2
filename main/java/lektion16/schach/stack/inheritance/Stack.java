package lektion16.schach.stack.inheritance;

import java.util.ArrayList;

public class Stack extends ArrayList<Object> {
    //Objekt ans ende der Liste
    public void push(Object o){
        this.add(o);
    }
    // nimmt das oberste Element vom Stack(Ende der Liste)

    public Object pop(){
        if(this.size() == 0){
            throw new IllegalStateException("Stack is empty");
        }
        //Element holen und entfernen
        return this.remove(this.size() - 1);
    }

}
