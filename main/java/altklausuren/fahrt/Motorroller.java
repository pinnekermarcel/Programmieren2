package altklausuren.fahrt;

public class Motorroller extends Fahrzeug{

    @Override
    public double berechneEntgelt(Fahrt f){
        return 3.0 + (0.15 * f.km);

    }
}
