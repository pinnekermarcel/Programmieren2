package altklausuren.twotter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class UserManager implements ObjectManager<User> {

    private static final String DATEI = "user.dat";

    @Override
    public void serialize(List<User> users){
        //Pipeline aufbauen
        try(FileOutputStream fos = new FileOutputStream(DATEI);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(users);

        }catch(Exception e){
            throw new RuntimeException("Fehler beim Speichern", e);
        }
    }
    @Override
    public List<User> deserialize(){
        try(FileInputStream fis =  new FileInputStream(DATEI);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            //Object einlesen
            //I eine List<Users> casten
            //return
            return (List<User>) ois.readObject();

        }catch(Exception e){
            throw new RuntimeException("Fehler beim laden der user", e);
        }
    }

}
