package altklausuren.twotter;

import java.time.LocalDate;

    public class Message {

        private final String text;
        private final String creationDate;

        public Message(String text) {
            this.text = text;
            // Speichert das aktuelle Datum automatisch als Text
            this.creationDate = LocalDate.now().toString();
        }

        public String getText() {
            return text;
        }

        public String getCreationDate() {
            return creationDate;
        }

        @Override
        public String toString() {
            return text;
        }
    }
