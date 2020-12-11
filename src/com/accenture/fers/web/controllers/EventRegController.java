package com.accenture.fers.web.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.fers.dao.VisitorDAO;
import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.EventFacade;
import com.accenture.fers.service.EventService;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

public class EventRegController implements IController {

	VisitorFacade servicio = new VisitorService();
	EventFacade eventService = new EventService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view = "/WEB-INF/portal.jsp";
		try {
			// Recuperar los parametros de la request

			String event = request.getParameter("idEvento");
			int eventID = Integer.parseInt(event);
			HttpSession sesion = request.getSession();
			Visitor usuario = (Visitor) sesion.getAttribute("visitor");

			// Crear una instancia del objeto Visitor

			// Crear la instancia del VisitorService

			servicio.registerVisitorToEvent(usuario, eventID);

			// llamamos al servico para recuperar los datos del visitante

			usuario = servicio.searchUser(usuario);
			sesion.setAttribute("visitor", usuario);
			Set<Event> listaEventos = new HashSet<Event>();

			// Relleno la lista usando el servicio
			listaEventos = eventService.getAllEvents();
			request.getServletContext().setAttribute("lista_Eventos", listaEventos);

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
		}

		return view;
	}

}
