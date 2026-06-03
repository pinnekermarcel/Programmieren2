package lektion22.prim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimzahlThread extends Thread {
    //Liste
   private List<Integer> zahlenliste;
   //Map
    private Map<Integer, Boolean> ergebnisMap;
    //a Konstruktor nimmmt eine Liste entgegen
    public PrimzahlThread(List<Integer> zahlenliste) {
        this.zahlenliste = zahlenliste;
        this.ergebnisMap = new HashMap<>();

    }

    public Map<Integer, Boolean> getErgebnisMap() {
        return ergebnisMap;
    }

    private boolean isPrim(int zahl){
        if(zahl <= 1) return false;
        for(int i = 2; i <= Math.sqrt(zahl); i++){
            if(zahl%i==0) return false;
        }
        return true;
    }
    @Override
    public void run() {
        for(int zahl : this.zahlenliste){
            boolean ergebnis = isPrim(zahl);
            this.ergebnisMap.put(zahl, ergebnis);
        }
    }


}
