package db;

import domain.Conversation;
import domain.Message;
import domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConversationRepoImplementation extends ConversationRepo {
    private ArrayList<Conversation> conversations = new ArrayList<>();

    @Override
    public void addConvo(Conversation conversation) {
        //System.out.println(conversations.containsKey(conversation.getReceiver().getUserId()));
        //Conversation c = new Conversation(conversation.getReceiver(),conversation.getSender());

        if(!conversations.isEmpty()) {
            for (Conversation c : conversations) {
                if ((c.getReceiver().getUserId().equals(conversation.getReceiver().getUserId()) && c.getSender().getUserId().equals(conversation.getSender().getUserId())) ||
                        (c.getReceiver().getUserId().equals(conversation.getSender().getUserId()) && c.getSender().getUserId().equals(conversation.getReceiver().getUserId()))) {
                    conversations.add(conversation);
                }
            }
        }else
            {
                conversations.add(conversation);
            }
        //System.out.println();
    }

    @Override
    public Conversation getConvo(String sender,String receiver) {
            if(!conversations.isEmpty()) {
                //System.out.println(sender);
                //System.out.println(receiver);
                for (Conversation c : conversations) {
                    //System.out.println(c.getReceiver().getUserId() + " en " + c.getSender().getUserId());
                    if ((c.getReceiver().getUserId().equals(receiver) && c.getSender().getUserId().equals(sender)) ||
                            (c.getReceiver().getUserId().equals(sender) && c.getSender().getUserId().equals(receiver))) {
                        return c;
                    }
                }
            }

        return null;
    }

    @Override
    public int getAmountOfMessages(String sender,String receiver) {
        if(!conversations.isEmpty()) {
            System.out.println(sender+" en "+receiver+ "bij genamount Of messages");
            for (Conversation c : conversations) {
                if ((c.getReceiver().getUserId().equals(receiver) && c.getSender().getUserId().equals(sender)) ||
                        (c.getReceiver().getUserId().equals(sender) && c.getSender().getUserId().equals(receiver))) {
                    return c.getTotalMessages();
                }
            }
        }
        return 7;
    }

    @Override
    public void update(String sender,String receiver,Message message) {

        for(Conversation c : conversations)
        {
            if ((c.getReceiver().getUserId().equals(receiver) && c.getSender().getUserId().equals(sender)) ||
                    (c.getReceiver().getUserId().equals(sender) && c.getSender().getUserId().equals(receiver))) {
                c.addMessage(message);

            }
        }

    }
}
