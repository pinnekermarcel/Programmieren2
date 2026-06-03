package lektion22.comperator;

import java.util.Comparator;

public class WortLaengenComperator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        //Länger beider Wörter verglcihen
       int laengenVergleich = Integer.compare(o1.length(), o2.length());
       //WEnn länge unterschiedlich
       if(laengenVergleich != 0){
           return laengenVergleich;
       }
       //Wenn länge gleich
       return o1.compareTo(o2);
    }
}
