package com.x.servletsFlightLog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PilotSearchServlet extends HttpServlet {
   private static final long serialVersionUID = -6242407356554453408L;
   String surname;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> reqParmMap = request.getParameterMap();
		String[] reqParmArr = (String[]) reqParmMap.get("surname");
		if (reqParmArr != null) {
			// TODO analyze parameters values
			// TODO set up search
			// TODO if object found, then display PilotDetailForm
			// otherwise display PilotSearchForm with message "not found"
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("nix");
			// TODO response depending on search result

		} else {
			// TODO no parameters: Please do in put
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.println("Eingabe fehlt!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public String getSurname() {
   	return surname;
   }

	public void setSurname(String surname) {
   	this.surname = surname;
   }
}
