package com.accenture.fers.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.fers.dao.EventDAO;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

public class SearchVisitorController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// Creamos la variable de retorno
		String view = "index.jsp";

		try {
			// Recuperar los parametros de la request
			String usuario = request.getParameter("visitorname");
			String password = request.getParameter("visitorpassword");
			request.getSession().setAttribute("username", usuario);
			request.getSession().setAttribute("password", password);
			// Crear una instancia del objeto Visitor
			Visitor visitor = new Visitor();

			// Asignamos valores a esta instancia
			visitor.setUserName(usuario);
			visitor.setPassword(password);

			// Crear la instancia del VisitorService
			VisitorFacade servicio = new VisitorService();

			// llamamos al servico para recuperar los datos del visitante
			visitor = servicio.searchUser(visitor);
			HttpSession sesion = request.getSession();
			sesion.setAttribute("visitorid", visitor.getVisitorId());
			sesion.setAttribute("phonenumber", visitor.getPhoneNumber());
			sesion.setAttribute("registeredevents", visitor.getRegisteredEvents());
			EventDAO eventDAO = new EventDAO();
			request.getSession().setAttribute("allEvents", eventDAO.findAll());
			// Compruebo que retorna informacion
			if (visitor != null) {
				view = "/WEB-INF/portal.jsp";
			}

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
		}

		return view;
	}
}
