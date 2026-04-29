package lektion17.Exception;

public class NumberFormatExc {
    public static void main(String[] args) {
        String keineZahl = "Hallo";
        int zahl = Integer.valueOf(keineZahl);
    }
}
