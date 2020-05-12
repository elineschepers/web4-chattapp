package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetAmountOfMessages extends AsyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String friend = request.getParameter("userId");
        System.out.println(getConvoService().getAmountOfMessages(friend));
        return Integer.toString(getConvoService().getAmountOfMessages(friend));

    }


}
