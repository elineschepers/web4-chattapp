package db;

import domain.Conversation;
import domain.Message;
import domain.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class ConversationRepo {

    public abstract void addConvo(Conversation conversation);

    public abstract Conversation getConvo(String userId);

    public abstract int getAmountOfMessages(String userid);
    public abstract void update(String userid,Message message);

}
