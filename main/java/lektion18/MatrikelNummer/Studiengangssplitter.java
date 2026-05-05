package lektion18.MatrikelNummer;

import java.io.*;

public class Studiengangssplitter {

    public void splitStudiengaenge(String dateiname) throws IOException, MatrikelNummerException {
        try(
                //1 reader
            BufferedReader br = new BufferedReader(new FileReader(dateiname));

            BufferedWriter writerInf = new BufferedWriter(new FileWriter("InfNr.txt"));
            BufferedWriter writerEC = new BufferedWriter(new FileWriter("ECNr.txt"));
            BufferedWriter writerWInf = new BufferedWriter(new FileWriter("WInfNr.txt"))
            ){
            String zeile;
            while((zeile = br.readLine()) != null){
                int nummer = Integer.parseInt(zeile);
                if(nummer >= 5000000 && nummer <= 5099999 ){
                    writerWInf.write(zeile);
                    writerWInf.newLine();
                }else if(nummer >= 5100000 && nummer <= 5199999 ){
                    writerInf.write(zeile);
                    writerInf.newLine();
                }else if(nummer >= 6100000 && nummer <= 6199999 ){
                    writerEC.write(zeile);
                    writerEC.newLine();
                }else{
                    throw new MatrikelNummerException("Ungültige Matrikelnummer! " + zeile);
                }
            }
        }
    }
    public static void main(String[] args){

        Studiengangssplitter studiengangssplitter = new Studiengangssplitter();

        try{
            studiengangssplitter.splitStudiengaenge("MatrNr.txt");
            System.out.println("Aufteilung war erfolgreich!");

        }catch(MatrikelNummerException e){
            System.err.println("Ungültige Matrikelnummer!" +  e.getMessage());

        } catch (IOException e) {
            System.err.println("Probleme mit den Dateien! " + e.getMessage());
        }
    }
}