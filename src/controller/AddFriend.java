package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriend extends SyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Person person = (Person) request.getSession().getAttribute("user");
        getPersonService().addFriend(person.getUserId(),new Person(request.getParameter("friend")));
        //System.out.println(person.getVrienden().toString());
        // dit is synchroon return "chatPage.jsp";
        return "Controller?action=Chat";
    }
}
