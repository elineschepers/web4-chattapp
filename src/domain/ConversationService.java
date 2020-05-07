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

    public Conversation getConvo(String userId)
    {
        return personRepository.getConvo(userId);
    }

    public int getAmountOfMessages(String userid){return  personRepository.getAmountOfMessages(userid);}
    public void update(String userid,Message message)
    {
        personRepository.update(userid,message);
    }
}
