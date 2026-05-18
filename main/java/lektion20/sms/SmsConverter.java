package lektion20.sms;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SmsConverter {

    public static Map<Character, Character> createKeyMap() {
        Map<Character, Character> map = new HashMap<>();
        //Ziffer 2
        map.put('A', '2');
        map.put('B', '2');
        map.put('C', '2');
        //ZIffer 3
        map.put('D', '3');
        map.put('E', '3');
        map.put('F', '3');
        map.put('G', '4');
        map.put('H', '4');
        map.put('I', '4');
        map.put('J', '5');
        map.put('K', '5');
        map.put('L', '5');
        map.put('M', '6');
        map.put('N', '6');
        map.put('O', '6');
        map.put('P', '7');
        map.put('Q', '7');
        map.put('R', '7');
        map.put('S', '7');
        map.put('T', '8');
        map.put('U', '8');
        map.put('V', '8');
        map.put('W', '9');
        map.put('X', '9');
        map.put('Y', '9');
        map.put('Z', '9');
        return map;
    }

    public static void main(String[] args) {
        Map<Character, Character> keypadMap = createKeyMap();
        String inputPfad = "Zeichenkontakte.txt";
        String outputPfad = "Nummernkontakte.txt";
        try(
                BufferedReader reader = new BufferedReader(new FileReader(inputPfad));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPfad));

                ){
            String line;
            while((line = reader.readLine())!= null){
                try{
                    String nummerString = translateWord(line, keypadMap);
                    writer.write(nummerString);
                    writer.newLine();
                }catch(IllegalTelephoneNumberException e){
                    System.err.println("Fehler beim übersetzten! " + e.getMessage());
                }


                System.out.println("gelesene Zeile: " + line);

            }
            System.out.println("Verarbeitung abgeschlossen.");
        } catch (FileNotFoundException e){
            System.err.println("fehler: Eingabedatei nicht gefunden! " + e.getMessage());
        } catch(IOException e){
            System.err.println("allg. IO Fehler! " + e.getMessage());
        }
    }
    public static String translateWord(String word, Map<Character, Character> map) throws IllegalTelephoneNumberException {
        StringBuilder result = new StringBuilder();
        String upperCaseWord = word.toUpperCase();

        for(int i = 0; i < upperCaseWord.length(); i++){
            char c = upperCaseWord.charAt(i);
            if(map.containsKey(c)){
                result.append(map.get(c));

            }else{
                throw new IllegalTelephoneNumberException(("ungültiges Zeichen... " + c + "in der eingabe: " + word));

            }
        }
        return result.toString();

    }
}
