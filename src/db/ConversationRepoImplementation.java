package db;

import domain.Conversation;
import domain.Message;
import domain.Person;

import java.util.HashMap;
import java.util.Map;

public class ConversationRepoImplementation extends ConversationRepo {
    private Map<String, Conversation> conversations = new HashMap<String, Conversation>();

    @Override
    public void addConvo(Conversation conversation) {
        System.out.println(conversations.containsKey(conversation.getReceiver().getUserId()));
        if(!conversations.containsKey(conversation.getReceiver().getUserId()))
        {
            conversations.put(conversation.getReceiver().getUserId(),conversation);
        }
        System.out.println(conversation.getReceiver().getUserId());
    }

    @Override
    public Conversation getConvo(String userId) {
        return conversations.get(userId);
    }

    @Override
    public int getAmountOfMessages(String userId) {
        return conversations.get(userId).getTotalMessages();
    }

    @Override
    public void update(String userid,Message message) {

        System.out.println(userid);
        System.out.println(conversations.get(userid));
        conversations.get(userid).addMessage(message);
    }
}
