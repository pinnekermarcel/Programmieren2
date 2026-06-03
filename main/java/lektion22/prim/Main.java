package lektion22.prim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Bsp zahlen erstellen
        List<Integer> liste1 = List.of(321, 12743432, 7, 12);
        List<Integer> liste2 = List.of(13, 19, 100, 23);
        //Mehrere PrimzahlThread Ojekte starten
        PrimzahlThread thread1 = new PrimzahlThread(liste1);
        PrimzahlThread thread2 = new PrimzahlThread(liste2);
        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            System.out.println("interrupted");
        }
        //Ergebnisse in einer Map zusammenlegen
        Map<Integer, Boolean> gesamtErgebnis = new HashMap<>();
        //Teilmaps holen un din eine Map zusammenlegen
        gesamtErgebnis.putAll(thread1.getErgebnisMap());
        gesamtErgebnis.putAll(thread2.getErgebnisMap());
        //Mappings ausgeben
        System.out.println("Ergebnis aller Threads");
        for(Map.Entry<Integer, Boolean> entry : gesamtErgebnis.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
