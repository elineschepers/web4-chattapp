package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GetAmountOfFriendsOnline extends AsyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Person p = ((Person) request.getSession().getAttribute("user"));
        int size =  getPersonService().getAllFriendsOnline(p.getUserId()).size();
        return Integer.toString(size);

    }
}
