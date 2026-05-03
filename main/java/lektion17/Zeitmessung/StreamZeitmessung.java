package lektion17.Zeitmessung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StreamZeitmessung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String quellPfad = "";
        boolean dateiGefunden = false;

        System.out.println("Stream_Kopier-Test!");

        do{
            System.out.println("Bitte gib den Pfad zur Testdatei ein (z.B. test.mp3): ");
            quellPfad = sc.nextLine();

            try(FileInputStream testStream = new FileInputStream(quellPfad)){
                dateiGefunden = true;
                System.out.println("Datei gefunden");
            } catch(FileNotFoundException e){
                System.out.println("Die Datei existiert nicht. Noch einmal versuchen.\n");
            }catch(IOException e){
                System.out.println("Allgemeiner Lesefehler!\n");
            }
        }while(!dateiGefunden);
        //next
    }
}
