package lektion15;

public abstract class Person {
   protected String fach;

     public Person(String fach) {
         this.fach = fach;
     }
     public abstract void gibTaetigkeitAus();

}
