package com.accenture.fers.web.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.EventService;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;
import com.accenture.fers.utils.IConstantes;

@Controller("/searchVisitor.do")
public class SearchVisitorController implements IController {

	@Autowired
	VisitorFacade servicio;

	@Autowired
	EventService eventService;

	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("index.jsp");
		try {
			// Creamos la variable de retorno
			HttpSession sesion = request.getSession();
			// Recuperar los parametros de la request
			String usuario = request.getParameter("visitorname");
			String password = request.getParameter("visitorpassword");

			// Crear una instancia del objeto Visitor
			Visitor visitor = new Visitor();

			// Asignamos valores a esta instancia
			visitor.setUserName(usuario);
			visitor.setPassword(password);

			// llamamos al servico para recuperar los datos del visitante
			visitor = servicio.searchUser(visitor);
			Set<Event> listaEventos = new HashSet<Event>();
			Set<Event> registeredEvents = new HashSet<Event>();

			registeredEvents = servicio.showRegisteredEvents(visitor);
			listaEventos = eventService.getAllEvents();

			request.getServletContext().setAttribute("lista_Eventos", listaEventos);
			request.getServletContext().setAttribute("registeredEvents", registeredEvents);
			// Compruebo que retorna informacion
			if (visitor != null) {
				view.setViewName("/WEB-INF/portal.jsp");
				sesion.setAttribute("visitor", visitor);
			} else {
				// agregar mensaje de error
				request.setAttribute("error", IConstantes.ERM_024);

			}

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());

		}

		return view;
	}
}
