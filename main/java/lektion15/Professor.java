package lektion15;

public class Professor extends Person {

    public Professor(String fach) {
        super(fach);
    }
    @Override
    public void gibTaetigkeitAus() {
        System.out.println("Professor Unterrichtet das Fach" + fach + " !");
    }
}
