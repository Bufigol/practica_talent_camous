package com.accenture.fers.web.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import com.accenture.fers.dao.EventDAO;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;
import com.accenture.fers.utils.IConstantes;

public class SearchVisitorController implements IController {
	VisitorFacade servicio = new VisitorService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view = "index.jsp";
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

			// Compruebo que retorna informacion
			if (visitor != null) {
				view = "/WEB-INF/portal.jsp";
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
