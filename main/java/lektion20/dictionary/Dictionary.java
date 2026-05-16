package lektion20.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    //kombi aus map und set
    private Map<String, Set<String>> multimap = new HashMap<>();

    //put Methode
    public void put(String englishWord, String germanWord){
        //faslls noch kein eintrag existiert
        if(!multimap.containsKey(englishWord)){
            //dann nues leeres set
            multimap.put(englishWord, new HashSet<>());

        }
        //set existiert
        multimap.get(englishWord).add(germanWord);
    }
    //get - MEthode
    public Set<String> get(String englishWord){
        return multimap.get(englishWord);
    }

}
