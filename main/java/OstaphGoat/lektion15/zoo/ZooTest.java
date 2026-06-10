package OstaphGoat.lektion15.zoo;

public class ZooTest {
    public static void main(String[] args) {
        Zootier[] meinZoo = new  Zootier[3];
        meinZoo[0] = new Loewe();
        meinZoo[1] = new Papagei();
        meinZoo[2] = new Elefant();

        System.out.println("---Zoorundgang startet---");
        for(Zootier zootier : meinZoo){
            zootier.makeSound();
        }
    }
}
