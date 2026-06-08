package altklausuren.fahrt;

public class Fahrrad extends Fahrzeug {

    @Override
    public double berechneEntgelt(Fahrt f){
        return 0.125 * f.min;

    }

}
