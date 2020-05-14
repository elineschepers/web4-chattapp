package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetStatus extends AsyncroonHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Person p = ((Person) request.getSession().getAttribute("user"));
        System.out.println("getstatus "+getPersonService().getStatus(p.getUserId()));
        String status= getPersonService().getStatus(p.getUserId());


        response.setStatus(200);
        return status;

    }

    public String toJSON(String status) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(status);
    }
}
