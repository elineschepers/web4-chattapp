package domain;

import java.util.ArrayList;
import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void addFriend(Person p,String personId){getPerson(personId).addVriend(p);}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}

	public void addFriend(String userId, Person friend) {getPersonRepository().addFriend(userId, friend);}

	public void changeStatus(String userId,String status){getPersonRepository().get(userId).setStatus(status);}
	public void removeFriend(String userId, Person friend) {getPersonRepository().removeFriend(userId,friend);}

	public ArrayList<Person> getAllFriends(String userId) {return getPersonRepository().getAllFriends(userId);}

	public ArrayList<Person> getAllFriendsOnline(String id)
    {
        ArrayList<Person> result=new ArrayList<>();
        for(Person p : getPersonRepository().getAllFriends(id))
        {
            if(p.getStatus().equals("ONLINE"))
            {
                result.add(p);
            }
        }
        return result;
    }
	public String getStatus(String personId){return personRepository.get(personId).getStatus();}
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}
}
