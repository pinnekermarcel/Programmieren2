package lektion15.Quiz;

public abstract class Frage {

    protected String text;

    public Frage(String text) {
        this.text = text;

    }
    public abstract void generiereAusgabe();

}
