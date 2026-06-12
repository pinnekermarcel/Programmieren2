package altklausuren.musikstueksammlung;

import java.util.*;

public class MusikStuecksammlung {

    //key(String) value(Musik-Stück-Objekt)
    private HashMap<String, MusikStueck> sammlung;

    public MusikStuecksammlung(){
        this.sammlung = new HashMap<>();
    }
    public void musikStueckEinfuegen(MusikStueck neu){
        if(sammlung.containsKey(neu.titel)){
            throw new IllegalArgumentException("MusikStuecksammlung ist bereits!");
        }
        sammlung.put(neu.titel, neu);
    }
    public List<MusikStueck> getMusikStueckNachTitel(){
        //Aus Map in die Liste packen
        List<MusikStueck> sortierteListe = new ArrayList<>(sammlung.values());
        //schiedsrichter
        Collections.sort(sortierteListe, new VergleicheMusikStueckTitel());
        return sortierteListe;
    }

    public List<MusikStueck> getAlleMusikStueckNachLaenge(){
        //alle werte in die liste
        List<MusikStueck> sortierteListe = new ArrayList<>(sammlung.values());
        //Schiedsrichter
        Collections.sort(sortierteListe, new VergleicheMusikStueckLaenge());
        return sortierteListe;
    }
}
