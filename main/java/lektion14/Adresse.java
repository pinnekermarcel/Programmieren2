package lektion14;

public class Adresse {
    String strasse;
    String hausnummer;
    String plz;
    String ort;
    public Adresse(String strasse, String hausnummer, String plz, String ort) {
        if(!Character.isUpperCase(strasse.charAt(0))) {
            throw new RuntimeException("strasse must start with uppercase letter");
        }
        if(!Character.isUpperCase(ort.charAt(0))) {
            throw new RuntimeException("ort must start with uppercase letter");
        }
        if(!Character.isDigit(hausnummer.charAt(0))) {
            throw new RuntimeException("hausnummer must start with digit");
        }
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }
}
