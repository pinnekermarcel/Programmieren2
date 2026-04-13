package lektion15;

public class Hochschule {
    public static void main(String[] args) {
        Person[] personen = new Person[100];
        String fachname = " Programmieren";

        for(int i = 0; i < personen.length; i++){
            if( i % 2 == 0){
                personen[i] = new Student(fachname);

            }else{
                personen[i] = new Professor(fachname);
            }
        }
        //Aufruf
        for(int i = 0; i < personen.length; i++){
            personen[i].gibTaetigkeitAus();
        }
    }


}
