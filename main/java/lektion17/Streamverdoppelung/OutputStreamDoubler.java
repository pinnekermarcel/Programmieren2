package lektion17.Streamverdoppelung;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDoubler extends OutputStream {
    //beide ZielStreams
    private OutputStream out1;
    private OutputStream out2;
    //Konstrktor
    public OutputStreamDoubler(OutputStream out1, OutputStream out2) {
        this.out1 = out1;
        this.out2 = out2;
    }
    @Override
    //write() methode
    public void write(int b) throws IOException {
        //STream 1

        try{
            if(out1 != null){
                out1.write(b);
            }
        }catch (IOException e){
            System.err.println("Fehler beim schreiben in Stream 1");
            e.printStackTrace();
        }
        //Stram 2
        try{
            if(out2 != null){
                out2.write(b);
            }
        }catch (IOException e){
            System.err.println("Fehler beim schreiben in Stream 2");
            e.printStackTrace();
        }
    }

    @Override
    //close() Methode
    public void close() throws IOException {
        //event. fehler merken
        IOException fehler1 = null;
        IOException fehler2 = null;

        //Versuch 1 Stream 1 schließen
        try{
            if (out1 != null){
                out1.close();
            }
        } catch (IOException e) {
            fehler1 = e; //fehler da? abgespeichert
        }
        //Versuch 2 Stream 2 schließen
        try{
            if (out2 != null){
                out2.close();
            }
        }catch (IOException e) {
            fehler2 = e; // fehler aufgetreten? abgespeichert
        }
        //auswerten unf ggf. neue Ex.
        if(fehler1 != null &&  fehler2 != null){
            //beide fehlgeschlagen
            throw new IOException("Fehler! beide Streams konnten nicht geschlossen werden! ");
        }else if(fehler1 != null){
            //nur Stram 1 fehlgechlagen
            throw new IOException("Fehler! stream 1 konnte nciht geshclossen werden", fehler1);
        }else if(fehler2 != null){
            //Nur Stream 1 fehlgeschlagen
            throw new IOException("Fehler! stream 2 konnte nciht geschlossen werden", fehler2);
        }
    }
    public static void main (String[] args){

        try{
            //beide streams anlegen
            FileOutputStream fos1 = new FileOutputStream("file1.txt");
            FileOutputStream fos2 = new FileOutputStream("file2.txt");
            //doubler
            OutputStreamDoubler doubler = new OutputStreamDoubler(fos1, fos2);
            //daten rdy machen
            String geheim = "Text wird auf 2 dateien verdoppelt";
            byte[] bytes = geheim.getBytes();

            //Daten in den Verdoppeler
            for(int i = 0; i < bytes.length; i++){
                doubler.write(bytes[i]);

            }
            doubler.close();

            System.out.println("Erfol!");


        }catch(IOException e){
            System.err.println("Fehler im der Main-Methode");
            e.printStackTrace();
        }
    }

}
