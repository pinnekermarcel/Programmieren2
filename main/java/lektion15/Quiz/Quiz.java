package lektion15.Quiz;

public class Quiz {
    public static void main(String[] args) {
        Frage[] quizbogen = new Frage[2];

        //1. Frage Textfrage
        quizbogen[0] = new TextFrage("Was ist die Hauptstadt von Deutschland? ");

        //2. Frage Multiplechoice
        String[] h2Antworten = {"4", "2", "1", "0"};
        quizbogen[1] = new MultipleChoiceFrage("Wie viele Protonen hat ein Wasserstoffatom?",  h2Antworten);

        System.out.println("-- QUIZBOGEN --");
        System.out.println();

        for(int i = 0; i < quizbogen.length; i++){
            quizbogen[i].generiereAusgabe();
            System.out.println("----------");
        }
    }
}
