package com.accenture.fers.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.fers.dao.VisitorDAO;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

public class EventRegController implements IController {
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
			// Recuperar los parametros de la request
			String usuario = request.getParameter("visitorname");
			String event = request.getParameter("eventID");
			int eventID = Integer.parseInt(event);
			VisitorDAO visitDAO = new VisitorDAO();

			// Crear una instancia del objeto Visitor
			Visitor visitor = visitDAO.findByUserName(usuario);

			// Crear la instancia del VisitorService
			VisitorFacade servicio = new VisitorService();
			servicio.registerVisitorToEvent(visitor, eventID);

			// llamamos al servico para recuperar los datos del visitante

			visitor = servicio.searchUser(visitor);

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
		}

		return view;
	}

}
