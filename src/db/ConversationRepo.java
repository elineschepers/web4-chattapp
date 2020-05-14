package db;

import domain.Conversation;
import domain.Message;
import domain.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class ConversationRepo {

    public abstract void addConvo(Conversation conversation);

    public abstract Conversation getConvo(String sender,String receiver);

    public abstract int getAmountOfMessages(String sender,String receiver);
    public abstract void update(String sender,String receiver,Message message);

}
