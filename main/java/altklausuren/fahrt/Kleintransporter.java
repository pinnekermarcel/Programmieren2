package altklausuren.fahrt;

public class Kleintransporter extends Fahrzeug {
    @Override
    public double berechneEntgelt(Fahrt f){
        if(f.min <= 60){
            return 0.30 * f.km;
        }
        return (0.30 * f.km) + (0.25 * (f.min - 60));
    }
}
