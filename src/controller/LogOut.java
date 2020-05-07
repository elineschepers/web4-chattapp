package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut extends SyncroonHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
		Person p = (Person) request.getSession().getAttribute("user");
		p.setStatus("OFFLINE");
		HttpSession session = request.getSession();

		session.invalidate();
		//return "index.jsp";
		return "index.jsp";

	}
	
}
