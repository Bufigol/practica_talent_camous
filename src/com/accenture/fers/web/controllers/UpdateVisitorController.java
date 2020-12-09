package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

public class UpdateVisitorController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// Creamos la variable de retorno
		String view = "portal.jsp";

		try {
			Visitor visitor = new Visitor();
			// Recuperar los parametros de la request
			String firstname = request.getParameter("firstname");
			visitor.setFirstName(firstname);
			String lastname = request.getParameter("lastname");
			visitor.setLastName(lastname);
			String email = request.getParameter("email");
			visitor.setEmail(email);
			String dni = request.getParameter("dni");
			visitor.setDni(dni);
			String phoneNumber = request.getParameter("phoneNumber");
			visitor.setPhoneNumber(phoneNumber);
			String address = request.getParameter("address");
			visitor.setAddress(address);

			// Crear la instancia del VisitorService
			VisitorFacade servicio = new VisitorService();
			servicio.updateVisitorDetails(visitor);

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
		}

		return view;
	}

}
