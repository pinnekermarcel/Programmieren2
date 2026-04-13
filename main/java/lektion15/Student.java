package lektion15;

public class Student extends Person {

    public Student(String fach){
        super(fach);

    }
    @Override
    public void gibTaetigkeitAus() {
        System.out.println("Student besucht das Fach" + fach + " !");

    }


}
