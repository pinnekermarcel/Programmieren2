package altklausuren.twotter;

import java.util.ArrayList;
import java.util.List;

public class TwotterTest {
    public static void main(String[] args) {
        //Liste + USer
        List<User> userListe = new ArrayList<>();
        userListe.add(new User("joe","joeRus!"));
        userListe.add(new User("anna", "anna123"));

        //fertigen Manager erstellen
        UserManager manager = new UserManager();
        //aufruf zum speichern
        System.out.println("Speichervorgang...");
        manager.serialize(userListe);
        System.out.println("Speichervorgang abgeschlossen");


    }




}
