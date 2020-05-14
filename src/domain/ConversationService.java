package domain;

import db.ConversationRepo;
import db.ConversationRepoImplementation;
import db.PersonRepository;
import db.PersonRepositoryStub;

public class ConversationService {

    private ConversationRepo personRepository = new ConversationRepoImplementation();

    public void addConvo(Conversation conversation)
    {
        personRepository.addConvo(conversation);
    }

    public Conversation getConvo(String sender,String receiver)
    {
        return personRepository.getConvo(sender,receiver);
    }

    public int getAmountOfMessages(String sender,String receiver){return  personRepository.getAmountOfMessages(sender,receiver);}
    public void update(String sender,String receiver,Message message)
    {
        personRepository.update(sender,receiver,message);
    }
}
