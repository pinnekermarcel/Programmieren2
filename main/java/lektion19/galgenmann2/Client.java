package lektion19.galgenmann2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String HOST = "localhost";//rufen uns selbst an
        final int PORT = 5000;

        try(
                //Leitung zum Server Aufbauen
                Socket socket = new Socket(HOST, PORT);
                //Den Leser für Tastatur
                BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
                //zuerst den ObjectOutputStream erstellen
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //Inputstream
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        ) {
            System.out.println("Verbunden! Tippe etwas ein:");
            String eingabe;
            while ((eingabe = tastatur.readLine()) != null) {
                // --A-- Wir nehmen den ersten Buchstaben und machen ihn groß
                char buchstabe  = eingabe.toUpperCase().charAt(0);
                //packet erstellen und abschicken
                //Wir erstellen ein Object
                RateVersuch versuch = new RateVersuch(buchstabe);
                oos.writeObject(versuch);
                oos.flush();
                //--B-- Antwort empfnagen
                //lesen das Antworten Object und Casten es
                ServerAntwort antwort = (ServerAntwort) ois.readObject();
                //--C-- Infos aus dem Object anzeigen
                System.out.println("AktuellerStand: " + antwort.getAktuellerStand() );
                if(antwort.isTreffer()){
                    System.out.println("--> Das war ein treffer :))");

                }else{
                    System.out.println("--> Das war kein treffer :(");
                }
                if(antwort.isWortErraten()){
                    System.out.println("--> Glückwusch, du hast das Wort erraten :)");
                    break;
                }
                if(antwort.isSpielBeendet()){
                    System.out.println("--> Game over... :(");
                    break;
                }
                System.out.println("Nächster Buchstabe: ");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Client: " + e.getMessage());
        }
    }
}
