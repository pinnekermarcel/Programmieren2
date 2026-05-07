package lektion19.galgenmann2;

import java.io.Serializable;

    // Serializable ist Pflicht, damit das Objekt durchs Netzwerk passt!
    public class RateVersuch implements Serializable {

        private char geratenerBuchstabe;

        public RateVersuch(char geratenerBuchstabe) {
            this.geratenerBuchstabe = geratenerBuchstabe;
        }

        public char getGeratenerBuchstabe() {
            return geratenerBuchstabe;
        }
    }
