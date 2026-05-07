package lektion19.galgenmann2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int PORT = 5000;
        System.out.println("Server started und wartet auf Port..." + PORT + "...");

        try (
                //Serversocket erstellen
                ServerSocket serverSocket = new ServerSocket(PORT);
                //warten auf client und nimmt ab
                Socket clientVerbindung = serverSocket.accept();
                //zuerst den OutputStream erstellen
                ObjectOutputStream oos = new ObjectOutputStream(clientVerbindung.getOutputStream());
                //dannach InputStream
                ObjectInputStream ois = new ObjectInputStream(clientVerbindung.getInputStream());



        ) {
            System.out.println("Client hat sich verbunden");

            //--c--
            String geheimWort = "INFORMATIK";
            //Char-array so lange wir das wort
            char[] ratestand =  new char[geheimWort.length()];
            //Array füllen
            for(int i= 0; i < ratestand.length; i++) {
                ratestand[i] = '_';
            }

            Object empfangen;
            //Wir lesen jetzt ganze Objekte

            while ((empfangen = ois.readObject())  != null) {
                //prüfen ob rateversuch
                if(empfangen instanceof RateVersuch) {
                    //Allgemeine Object in Rateversuch(cast)
                    RateVersuch versuch = (RateVersuch) empfangen;
                    //wir holen uns Buchstaben aus dem Object
                    char geraten = versuch.getGeratenerBuchstabe();
                    System.out.println("Client rät..." + geraten);

                    boolean treffer = false;
                    for(int i = 0; i < geheimWort.length(); i++) {
                        if(geheimWort.charAt(i) == geraten) {
                            ratestand[i] = geraten;
                            treffer = true;
                        }
                    }
                    String aktuellerStand = new String(ratestand);
                    boolean gewonnen = aktuellerStand.equals(geheimWort);
                    if(gewonnen) {
                        System.out.println("Client gewonnen");
                    }
                    //Object der Klasse Serverantwort
                    //Konstruktor den passenden Wert übergeben
                    ServerAntwort antwort = new ServerAntwort(aktuellerStand, gewonnen, false, treffer);

                    //Schicke das Object über den ObjectOutputstream (oos) ab!
                    oos.writeObject(antwort);
                    //flush
                    oos.flush();


                }

            }
            System.out.println("Client hat aufgelegt");
        } catch (IOException | ClassNotFoundException e ) {

            System.err.println("Netzerkfehler: " + e.getMessage());
        }

    }
}
