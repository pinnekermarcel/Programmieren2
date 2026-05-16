package lektion20.dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        //befüllen
        dictionary.put("to clean", "reinigen");
        dictionary.put("to clean", "säubern");
        dictionary.put("to clean", "putzen");

        dictionary.put("to exercise", "üben");
        dictionary.put("to exercise", "trainieren");

        //ausgeben
        System.out.println("Übersetzung von to clean: " + dictionary.get("to clean"));
        System.out.println("Übersetzung von to exercise: " + dictionary.get("to exercise"));
        //dublikate werden ignoriert und Wörter die wir nicht kennen geben null zurück

    }
}
