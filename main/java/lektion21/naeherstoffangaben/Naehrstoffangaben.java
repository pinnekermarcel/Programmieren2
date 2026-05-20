package lektion21.naeherstoffangaben;

public class Naehrstoffangaben {
    //Att. und priv. Konstruktor
    int portionsgroesse;
    int anzahlPortionen;
    double eiweiss;
    double fett;
    double kohlenhydrate;
    double natrium;

    private Naehrstoffangaben(NaehrstoffangabenBuilder builder) {
        this.portionsgroesse = builder.portionsgroesse;
        this.anzahlPortionen = builder.anzahlPortionen;
        this.eiweiss = builder.eiweiss;
        this.fett = builder.fett;
        this.kohlenhydrate = this.kohlenhydrate;
        this.natrium = builder.natrium;

    }
    public static class NaehrstoffangabenBuilder {
        int portionsgroesse;
        int anzahlPortionen;
        double eiweiss;
        double fett;
        double kohlenhydrate;
        double natrium;

        public NaehrstoffangabenBuilder(int portionsgroesse, int anzahlPortionen) {
            this.portionsgroesse = portionsgroesse;
            this.anzahlPortionen = anzahlPortionen;
        }

        //Optionale setter( Method Chaining)
        public NaehrstoffangabenBuilder withEiweiss(double eiweiss) {
            this.eiweiss = eiweiss;
            return this;//gibt den builder zurük
        }

        public NaehrstoffangabenBuilder withFett(double fett) {
            this.fett = fett;
            return this;
        }

        public NaehrstoffangabenBuilder withKohlenhydrate(double kohlenhydrate) {
            this.kohlenhydrate = kohlenhydrate;
            return this;
        }

        public NaehrstoffangabenBuilder withNatrium(double natrium) {
            this.natrium = natrium;
            return this;
        }

        //finale Methode, die das Objekt erzeugt
        public Naehrstoffangaben build() {
            return new Naehrstoffangaben(this);
        }
    }
    public static void main(String[] args) {

        // Beispiel: Wir erstellen eine Portion Müsli.
        // Pflicht: 250g Portionsgröße, 1 Portion.
        // Optional: Nur Kohlenhydrate und Eiweiß. (Fett und Natrium lassen wir weg).

        Naehrstoffangaben muesli = new Naehrstoffangaben.NaehrstoffangabenBuilder(250, 1)
                .withKohlenhydrate(50.5)
                .withEiweiss(10.2)
                .build();

        // Beispiel 2: Ein Wasser hat gar keine Nährstoffe.
        // Hier rufen wir direkt nach dem Konstruktor build() auf.
        Naehrstoffangaben wasser = new Naehrstoffangaben.NaehrstoffangabenBuilder(500, 1).build();

        System.out.println("Objekte wurden erfolgreich mit dem Builder Pattern erstellt!");
    }
}
