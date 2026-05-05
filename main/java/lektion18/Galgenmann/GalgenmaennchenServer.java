package lektion18.Galgenmann;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class GalgenmaennchenServer {

    public static void main(String[] args) {
        final int PORT = 5000;
        System.out.println("Server started und wartet auf Port..." + PORT + "...");

        try (
                //Serversocket erstellen
                ServerSocket serverSocket = new ServerSocket(PORT);
                //warten auf client und nimmt ab
                Socket clientVerbindung = serverSocket.accept();
                //Reader für eingehende Nachrichten
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientVerbindung.getInputStream()));
                //Writer für ausgehende Nachrichten
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientVerbindung.getOutputStream()));

        ) {
            System.out.println("Client hat sich verbunden");
            String empfangen;

            //--c--
            String geheimWort = "INFORMATIK";
            //Char-array so lange wir das wort
            char[] ratestand =  new char[geheimWort.length()];
            //Array füllen
            for(int i= 0; i < ratestand.length; i++) {
                ratestand[i] = '_';
            }
            //Schleife zum lesen
            while ((empfangen = reader.readLine()) != null) {
                System.out.println("Client rät: " + empfangen);
                //Auf text -> einzelnen Buchstaben
                char geraten = empfangen.toUpperCase().charAt(0);
                //jeden buchstaben durchgehen
                for(int i = 0; i < geheimWort.length(); i++) {
                    //wenn bchstabe an i mir geratenen zahl übereinstimmt
                    if(geheimWort.charAt(i) == geraten) {
                        //unterstrich ersetzten
                        ratestand[i] = geraten;
                    }
                }
                // zeichenArray -> normalesArray
                String antwort = new String(ratestand);

                //Client ok zurücksenden
                writer.write(antwort);
                writer.newLine();
                writer.flush();
                //prüfen ob wort erraten wurde
                if(antwort.equals(geheimWort)){
                    System.out.println("Spiel vorbei, Client hat das Wort erraten!!");
                }
            }
            System.out.println("Client hat aufgelegt");
        } catch (IOException e) {

            System.err.println("Netzerkfehler: " + e.getMessage());
        }

    }

}
