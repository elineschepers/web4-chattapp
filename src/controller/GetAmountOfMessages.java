package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetAmountOfMessages extends AsyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String friend = request.getParameter("userId");
        String me = ((Person) request.getSession().getAttribute("user")).getUserId();
        //System.out.println(getConvoService().getAmountOfMessages(me,friend));
        return Integer.toString(getConvoService().getAmountOfMessages(me,friend));

    }


}
