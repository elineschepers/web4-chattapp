package domain;

import java.util.ArrayList;

public class Conversation {
    private Person sender, receiver;
    private ArrayList<Message> messages;

    public Conversation(Person sender, Person receiver) {
        this.sender = sender;
        this.receiver = receiver;
        messages=new ArrayList<>();
    }

    public Person getSender() {
        return sender;
    }

    public Person getReceiver() {
        return receiver;
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
