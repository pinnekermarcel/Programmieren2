package lektion22.comperator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Kreuzwortraetsel {
    static String[] alleWoerter = {"Bienenschwarm", "Buch", "Bibel",
            "Beige", "Barriere", "Bein", "Beil", "Christ", "Christian", "Carmen"};

    public static void main(String[] args) {

        /*// Wir übergeben unseren Comparator!
        TreeSet<String> t = new TreeSet<>(new WortLaengenComperator());

        t.addAll(Arrays.asList(alleWoerter));

        for (String wort : t) {
            System.out.println(wort);
        }
    }*/
        //Anonyme klasse
        //
        TreeSet<String> t = new TreeSet<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                int laengenVergleich = Integer.compare(o1.length(), o2.length());
                if (laengenVergleich != 0) {
                    return laengenVergleich;
                }
                return o1.compareTo(o2);
            }
        });
        t.addAll(Arrays.asList(alleWoerter));
        for(String wort : t){
            System.out.println(wort);
        }


    }
}
