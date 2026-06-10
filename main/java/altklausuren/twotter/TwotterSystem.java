package altklausuren.twotter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwotterSystem {
    //Map verknüpft user mit messages
    private Map<User, List<Message>> userMessages;
    //konstruktor zum init.
    public TwotterSystem() {
        userMessages = new HashMap<>();
    }
    public void addMessage(User user, Message message) {
        if(!userMessages.containsKey(user)) {
            userMessages.put(user, new ArrayList<>());
        }
        userMessages.get(user).add(message);
    }

    public List<Message> getAllMessagesFromUser(User user) {
        if(!userMessages.containsKey(user)){
            return new ArrayList<>();
        }
        return userMessages.get(user);
    }
    public List<Message> getAllMessages() {
        List<Message> allMessages = new ArrayList<>();
        for(List<Message> userListe : userMessages.values()){
            allMessages.addAll(userListe);
        }
        return allMessages;
    }
    public List<Message> getAllMessagesFromDate(String date) {
        List<Message> gefundeneNachrichten = new ArrayList<>();
        List<Message> alle = getAllMessages();

        for(Message m : alle){
            if(m.getCreationDate().equals(date)){
                gefundeneNachrichten.add(m);
            }
        }
        return gefundeneNachrichten;
    }

}
