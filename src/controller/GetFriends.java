package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetFriends extends AsyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        //System.out.println(user);
    String userJson="";
        if (user != null ) {

             userJson = this.toJSON(getPersonService().getAllFriends(user.getUserId()));
            response.setContentType("application/json");

        } else if(request.getParameter("chat") == null) {
        }
        response.setStatus(200);
        //return "chatPage.jsp";
        //stuurt Json
        //System.out.println(userJson);
        return userJson;

    }
    public String toJSON(ArrayList<Person> friends) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(friends);
    }
    }

