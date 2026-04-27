package lektion16.schach.Cyborg;

public class Roboter {
    public void aufladen(){
        System.out.println("Roboter läd auf...");
    }
    public void warten(){
        System.out.println("Roboter wartet...");
    }
    public void arbeiten(){
        System.out.println("Roboter arbeitet...");
    }

    public Entscheidung entscheide(Gefahr gefahr){
        switch (gefahr){
            case GEFAHR_LINKS: return Entscheidung.RECHTS;
            case GEFAHR_RECHTS: return Entscheidung.LINKS;
            case GEFAHR_VORNE: return Entscheidung.BREMSEN;
            default: return Entscheidung.UNENTSCHIEDEN;
        }
    }

}
