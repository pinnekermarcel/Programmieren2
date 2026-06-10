package altklausuren.twotter;

import java.io.Serializable;

public class User implements Serializable {
    private String passwort;
    private final String benutzername;

    public User(String passwort, String benutzername) {
        this.passwort = passwort;
        this.benutzername = benutzername;
    }
    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public String getBenutzername() {
        return benutzername;
    }

}
