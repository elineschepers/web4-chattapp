package controller;

import domain.Conversation;
import domain.ConversationService;
import domain.PersonService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, PersonService model,ConversationService conversationService) {
        return createHandler(key, model,conversationService);
    }
    
	private RequestHandler createHandler(String handlerName, PersonService model,ConversationService conversationService) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setModel(model,conversationService);
		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
