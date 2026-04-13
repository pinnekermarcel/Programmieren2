package lektion15.Quiz;

public class MultipleChoiceFrage extends Frage{

    private String[] antwortmoeglichkeiten;

    public MultipleChoiceFrage(String text, String[] antworten) {
        super(text);
        this.antwortmoeglichkeiten = antworten;

    }
    @Override
    public void generiereAusgabe() {
        System.out.println("Fragetext: ");
        System.out.println(text);
        System.out.println();
        System.out.println("Antwortmöglichekiten: ");

        char ch = 'A';
        for (int i = 0; i < antwortmoeglichkeiten.length; i++) {
            System.out.println(ch + ": " +  antwortmoeglichkeiten[i]);
            ch++;
        }
        System.out.println();
    }

}
