package lektion21.exam;

public class Question {

        String text; // Fragentext [cite: 812]

        // Wandelt eine eingelesene Zeile in ein Question-Objekt um [cite: 813]
        public static Question toQuestion(String line) {
            Question q = new Question();
            q.text = line; // Stark vereinfacht, reicht aber zum Testen!
            return q;
        }
}
