package com.accenture.fers.web.controllers;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.dao.IVisitorDAO;
import com.accenture.fers.dao.VisitorDAO;
import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.EventFacade;
import com.accenture.fers.service.EventService;
import com.accenture.fers.service.VisitorFacade;

@Controller("/displayView.do")
public class DisplayViewController implements IController {

	@Autowired
	VisitorFacade servicio;
	
	@RequestMapping("/displayView.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/WEB-INF/portal.jsp");
		try {
			String usuario = request.getParameter("visitorname");
			IVisitorDAO visitDAO = new VisitorDAO();

			// Crear una instancia del objeto Visitor
			Visitor visitor = visitDAO.findByUserName(usuario);

			Set<Event> registedEvents = servicio.showRegisteredEvents(visitor);
			request.setAttribute("registedEvents", registedEvents);
			EventFacade eventService = new EventService();
			Set<Event> allEvents = eventService.getAllEvents();
			request.setAttribute("allEvents", allEvents);
		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
		}
		return view;
	}

}
