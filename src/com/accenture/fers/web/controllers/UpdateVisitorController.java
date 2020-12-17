package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

@Controller("/updateVisitor.do")
public class UpdateVisitorController implements IController {

	@Autowired
	VisitorFacade servicio;

	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		// Creamos la variable de retorno
		ModelAndView view = new ModelAndView("WEB-INF/updateVisitorInformation.jsp");

		try {
			Visitor visitor = new Visitor();
			// Recuperar los parametros de la request
			visitor.setUserName(request.getParameter("userName"));
			visitor = servicio.searchUser(visitor);
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

			int result = servicio.updateVisitorDetails(visitor);

			if (result == 1) {
				view.setViewName("portal.jsp");
			}

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
			System.out.println(error.getMessage());
		}

		return view;
	}

}
