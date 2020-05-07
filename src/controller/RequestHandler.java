package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;

import java.io.IOException;

public abstract class RequestHandler {
	
	private PersonService personService;
	private ConversationService conversationService;
	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void setModel (PersonService personService,ConversationService conversationService) {
		this.personService = personService;
		this.conversationService=conversationService;
	}

	public PersonService getPersonService() {
		return personService;
	}
	public ConversationService getConvoService() {return conversationService;}
	protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null && person.getRole().equals(role)) {
			return true;
		}
		return false;
	}

}
