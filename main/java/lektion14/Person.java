package lektion14;

public class Person {
    String vorname;
    String nachname;
    Adresse adresse;

    public Person(String vorname, String nachname, Adresse adresse) {
        if (!Character.isUpperCase(vorname.charAt(0))) {
            throw new RuntimeException("vorname must start with uppercase letter");
        }
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;

    }


}
