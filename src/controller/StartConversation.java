package controller;

import domain.Conversation;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

public class StartConversation extends SyncroonHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String friend = request.getParameter("friend");
        Person inSession = (Person) request.getSession().getAttribute("user");

        //System.out.println(friend);
        System.out.println("conversation established");
        Conversation conversation = new Conversation(inSession,getPersonService().getPerson(friend));
        getConvoService().addConvo(conversation);
        //request.getSession().setAttribute("convo",conversation);
        response.setStatus(200);
        return "in orde";
    }
}
