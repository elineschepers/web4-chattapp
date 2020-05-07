package db;

import java.util.ArrayList;
import java.util.List;

import domain.Person;

public interface PersonRepository {

	public abstract void add(Person person);

	public abstract void delete(String userId);

	public abstract Person get(String userId);

	public abstract List<Person> getAll();
	
	public abstract Person getAuthenticatedUser(String email, String password);

	public abstract void update(Person person);

	void addFriend(String userId, Person friend);

	ArrayList<Person> getAllFriends(String userId);

	void removeFriend(String userId, Person friend);
}