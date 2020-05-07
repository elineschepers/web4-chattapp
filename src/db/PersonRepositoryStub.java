package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;
import domain.Role;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	
	public PersonRepositoryStub () {
		Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", Role.BIB);
		add(administrator);
		Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", Role.LID);
		add(jan);
		Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", Role.LID);
		add(an);
		Person eline = new Person("eline@schepers.be", "t", "Eline", "Schepers", Role.LID);
		add(eline);
		jan.addVriend(eline);
		jan.addVriend(an);

	}
	
	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}
	
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}

	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);
		
		if (person != null && person.isCorrectPassword(password)) {
			return person;
		}
		else {
			return null;
		}
	}

	@Override
	public void addFriend(String userId, Person friend) {
		if(!persons.containsKey(friend.getUserId()))
		{
			add(friend);
			//System.out.println("KIJK HIEERRRR "+persons.size());

		}

		Person p = this.persons.get(userId);

		p.addVriend(friend);


	}

	@Override
	public ArrayList<Person> getAllFriends(String userId) {
		if (this.persons.containsKey(userId)) {
			List<Person> friends = new ArrayList<>();
			for (Person person : this.persons.get(userId).getVrienden()) {
				{
					friends.add(person);
				}

			}
			return (ArrayList<Person>) friends;
		} else {
			return new ArrayList<>();
		}

	}

	@Override
	public void removeFriend(String userId, Person friend) {

	}


}
