package lektion21;

import java.io.IOException;

interface ExamToTest {
    void toTest() throws IOException;
    // Die eigentliche Exam-Klasse steuert den Ablauf
    public class FluentExam implements ExamToTest {

        // Diese Methode startet den Ablauf. Sie gibt das Interface zurück
        public ExamToTest readQuestions() throws IOException {
            // ... (Logik zum Einlesen aus Teil a)

            return this; // Wir geben uns selbst als "ExamToTest" zurück
        }

        // Diese Methode ist über das Interface erst NACH readQuestions() erreichbar
        @Override
        public void toTest() throws IOException {
            // ... (Logik zum Schreiben aus Teil b)
        }
    }

}
