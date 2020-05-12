package controller;

import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUp extends SyncroonHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String pwd=request.getParameter("password");
        String confirmPwd=request.getParameter("confirmpassword");
        int age =Integer.parseInt(request.getParameter("age"));

        if(pwd.equals(confirmPwd)) {
            Person p = new Person(email,pwd,surname,name, Role.LID);
            getPersonService().addPerson(p);
        }
        return "index.jsp";
    }
}
