package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetMessages extends AsyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String friend = request.getParameter("userId");
        String me = ((Person) request.getSession().getAttribute("user")).getUserId();
        String json = this.toJSON(getConvoService().getConvo(me,friend).getMessages());

        return json;
    }

    public String toJSON(ArrayList<Message> messages) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(messages);
    }
}
