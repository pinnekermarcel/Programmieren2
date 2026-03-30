package lektion14;

public class Kugelvolumen {
    public static double berechneKugelvolumen(double radius) {
        if (radius < 0) {
            throw new RuntimeException("Radius darf nicht negativ sein.");
        }
        return 4.0 / 3.0 * Math.PI * radius * radius * radius;
    }
}
