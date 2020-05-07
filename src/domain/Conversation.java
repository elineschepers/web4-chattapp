package domain;

import java.util.ArrayList;

public class Conversation {
    private Person p1, p2;
    private ArrayList<Message> messages;

    public Conversation(Person p1, Person p2) {
        this.p1 = p1;
        this.p2 = p2;
        messages=new ArrayList<>();
    }

    public Person getSender() {
        return p1;
    }

    public Person getReceiver() {
        return p2;
    }

    public int getTotalMessages()
    {
        return messages.size();
    }
    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message)
    {

        messages.add(message);
    }
}
