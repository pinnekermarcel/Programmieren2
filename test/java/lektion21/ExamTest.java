package lektion21;

import lektion21.exam.Exam;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExamTest {
    @Test
    public void testExam() throws Exception {
        // Instanz von Exam erstellen
        Exam exam = new Exam();

        File zielDatei = new File("test.tex");
        if(zielDatei.exists()){
            zielDatei.delete();
        }

        exam.readQuestions();
        exam.toTest();

        assertTrue(zielDatei.exists(), "Die Datei test.tex sollte nach dem Aufruf existieren");
    }
}
