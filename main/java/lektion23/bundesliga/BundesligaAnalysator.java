package lektion23.bundesliga;

import java.util.List;

import static java.util.Locale.filter;

public class BundesligaAnalysator {
    public static void main(String[] args) {
        //Bundesliga tabelle erstellen
        List<Mannschaft> tabelle = Mannschaft.createTabelle();

        System.out.println("--Mannschaften mit mehr als 50 Punten--");
        //Pipeline aufbauen
        tabelle.stream()
                .filter(m  -> m.punkte > 50)
                .forEach(m -> System.out.println(m));

        System.out.println("--Alle Mannschaftsnamen--");
        tabelle.stream()
                //Objekt -> String
                .map(m -> m.name)
                .forEach(name -> System.out.println(name));

        System.out.println("--Alle Mannschaftsnamen nach F(sortiert)--");
        tabelle.stream()
                .map(m -> m.name)
                .filter(name -> name.startsWith("F"))
                .sorted()
                .forEach(name -> System.out.println(name));

        System.out.println("--Meiste Gegentore");
        tabelle.stream()
                .max((m1, m2) -> Integer.compare(m1.gegentore,  m2.gegentore))
                .ifPresent(m -> System.out.println(m.name + " (" + m.gegentore + " Gegentore)"));


    }
}
