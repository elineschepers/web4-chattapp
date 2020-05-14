package controller;

import domain.Conversation;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddMessage extends AsyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(request.getParameter("userId"));
        Person friend = getPersonService().getPerson(request.getParameter("userId"));
        Person me = (Person) request.getSession().getAttribute("user");
        System.out.println(friend.getFirstName());
        Message message = new Message(me,request.getParameter("message"));
        System.out.println(message.getMessage());
        getConvoService().update(me.getUserId(),friend.getUserId(),message);
        System.out.println("het bericht: "+message.getMessage());
        response.setStatus(200);
        return message.getMessage();
    }
}
