package com.accenture.fers.web.controllers;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.accenture.fers.dao.VisitorDAO;
import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.EventService;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

@Controller("/displayView.do")
public class DisplayViewController implements IController {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view = "/WEB-INF/portal.jsp";
		try {
			String usuario = request.getParameter("visitorname");
			VisitorDAO visitDAO = new VisitorDAO();

			// Crear una instancia del objeto Visitor
			Visitor visitor = visitDAO.findByUserName(usuario);
			VisitorFacade servicio = new VisitorService();
			Set<Event> registedEvents = servicio.showRegisteredEvents(visitor);
			request.setAttribute("registedEvents", registedEvents);
			EventService eventService = new EventService();
			Set<Event> allEvents = eventService.getAllEvents();
			request.setAttribute("allEvents", allEvents);
		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
		}
		return view;
	}

}
