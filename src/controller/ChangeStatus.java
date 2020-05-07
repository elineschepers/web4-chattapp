package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeStatus extends SyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Person p= (Person) request.getSession().getAttribute("user");
        getPersonService().changeStatus(p.getUserId(),request.getParameter("newStatus").toUpperCase());

        return "Controller?action=Chat";

    }

}
