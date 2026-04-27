package lektion16.schach.Münzautomat.muenzautomat;

public class OptimalChangeCal implements ChangeCalculator {
    @Override
    public int[] getChange(int euros, int cent) {
        // Gesamten Betrag in Cent umrechnen
        int totalCent = euros * 100 + cent;

        int[] result = new int[8];
        Coin[] coins = Coin.values(); // Holt uns alle Münzen aus dem Enum (von 1 Cent bis 2 Euro)

        // Wir fangen bei der größten Münze (Index 7 = EURO_2) an und arbeiten uns runter zu Index 0
        for (int i = 7; i >= 0; i--) {
            int coinValue = coins[i].value; // Wert aus dem Enum auslesen (z.B. 200 bei EURO_2)

            result[i] = totalCent / coinValue;    // Wie oft passt die Münze in den Restbetrag?
            totalCent = totalCent % coinValue;    // Den Restbetrag für die nächste Münze aktualisieren
        }

        return result;
    }

}
