package lektion21.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Exam {

    // a): Speichert mehrere Question-Objekte im Exam
    private List<Question> fragenListe = new ArrayList<>();

    String readHeaderFromFile() {
        return "\\documentclass[10pt,a4paper]{article}\n"
                + "\\usepackage[lmargin=2.5cm, rmargin=2.5cm]{geometry}\n"
                + "\\usepackage[utf8]{inputenc}\n"
                + "\\begin{document}\n";
    }
    public void readQuestions() throws IOException {
        // try-with-resources schließt den Reader automatisch
        try (BufferedReader reader = new BufferedReader(new FileReader("questions.csv"))) {
            String line;
            // Zeilenweise auslesen
            while ((line = reader.readLine()) != null) {
                // Zeile an die statische Methode übergeben
                Question neueFrage = Question.toQuestion(line);
                // In der Liste speichern
                fragenListe.add(neueFrage);
            }
        }
    }
    public void toTest() throws IOException {
        // try-with-resources schließt den Writer automatisch
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.tex"))) {

            // 1. Erst den Header in die Datei schreiben
            String header = readHeaderFromFile();
            writer.write(header);
            writer.newLine();

            // 2. Alle Fragen im LaTeX-Format zeilenweise schreiben
            for (Question q : fragenListe) {
                // Das geforderte Format: \textbf{Fragentext}\\
                String texZeile = "\\textbf{" + q.text + "}\\\\";
                writer.write(texZeile);
                writer.newLine();
            }

            // 3. Datei abschließen
            writer.write("\\end{document}");
        }
    }
}
