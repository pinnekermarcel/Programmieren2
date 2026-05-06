package lektion18.GZIP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.GZIPOutputStream;

public class Client {
    public static void main(String[] args) throws IOException {


        byte[] bytesToTransfer = "Hallo Welt\n".getBytes();
        Socket connectionToHost = new Socket("localhost", 5555);
        OutputStream os = connectionToHost.getOutputStream();
        GZIPOutputStream gzos = new GZIPOutputStream(os);
        gzos.write(bytesToTransfer);
        gzos.close();
    }
}
