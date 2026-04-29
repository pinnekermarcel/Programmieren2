package lektion17.Exception;

public class NullPointerException {
    public static void main(String[] args) {
        String txt = null;

        int laenge = txt.length();
    }
}
