package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

public class ChangePasswordController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view = "/portal.jsp";
		try {
			// Recuperar los parametros de la request
			String usuario = request.getParameter("visitorname");
			String password = request.getParameter("currentPassword");

			// Crear una instancia del objeto Visitor
			Visitor visitor = new Visitor();

			// Asignamos valores a esta instancia
			visitor.setUserName(usuario);
			visitor.setPassword(password);

			// Crear la instancia del VisitorService
			VisitorFacade servicio = new VisitorService();

			// llamamos al servico para recuperar los datos del visitante
			visitor = servicio.searchUser(visitor);

			// obtengo la nueva password y la actualizamos
			String newPasword = request.getParameter("newPassword");
			visitor.setPassword(newPasword);

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
		}
		return view;
	}

}
