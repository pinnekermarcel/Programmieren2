package lektion15.Quiz;

public class TextFrage extends Frage {

    public TextFrage(String text) {
        super(text);
    }
    @Override
    public void generiereAusgabe() {
        System.out.println(text);
        System.out.println();
        System.out.print("Antwort: ");
        System.out.println();//Zeile 1
        System.out.println();//Zeile 2


    }


}
