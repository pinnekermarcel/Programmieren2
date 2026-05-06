package lektion18.GZIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.GZIPInputStream;

public class Server {
    public static void main(String[] args) throws IOException {
        final int PORT = 5555;
        System.out.println("Server startet und wartet auf PORT..." + PORT + "...");
        try (
                //serversocket starten
                ServerSocket serverSocket = new ServerSocket(PORT);
                //Auf anruf warten(nimmt ab)
                Socket client = serverSocket.accept();
                //Entpacker auf den eingehenden Datenstrom des Clients stecken
                GZIPInputStream gzis = new GZIPInputStream(client.getInputStream());
                //alles lesbar machen
                BufferedReader reader = new BufferedReader(new InputStreamReader(gzis));


        ) {
            //Nachrichten lesen und ausgeben
            String empfangen = reader.readLine();
            System.out.println("Nachricten empfangen! " +  empfangen );

        } catch (IOException e) {
            System.err.println("Fehler: " + e.getMessage());

        }
    }



}
