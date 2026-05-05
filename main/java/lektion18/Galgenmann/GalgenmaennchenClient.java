package lektion18.Galgenmann;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class GalgenmaennchenClient {
    public static void main(String[] args) {
        final String HOST = "localhost";//rufen uns selbst an
        final int PORT = 5000;

        try(
                //Leitung zum Server Aufbauen
                Socket socket = new Socket(HOST, PORT);
                //Den Leser für Tastatur
                BufferedReader tastatur = new BufferedReader(new InputStreamReader(System.in));
                //schreiber zum Server aufbauen
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                //den reader aufbauen
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
            System.out.println("Verbunden! Tippe etwas ein:");
            String eingabe;
            while ((eingabe = tastatur.readLine()) != null) {
                //schicke eingabe an server
                writer.write(eingabe);
                writer.newLine();
                writer.flush();
                //warte auf antwort und gib sie aus
                String serverAntwort =  reader.readLine();
                System.out.println("Antwort vom Server: " + serverAntwort);

            }
        } catch (IOException e) {
            System.err.println("Fehler beim Client: " + e.getMessage());
        }
    }
}
