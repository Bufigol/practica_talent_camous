package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.VisitorFacade;

@Controller
public class NewVisitorController implements IController {
	@Autowired
	VisitorFacade servicio;
	
	@RequestMapping("/newVisitor.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/index.jsp");
		try {
			// Recuperar los parametros de la request
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String dni = request.getParameter("dni");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");

			Visitor visitor = new Visitor();
			visitor.setUserName(username);
			visitor = servicio.searchUser(visitor);
			if (visitor == null) {
				visitor = new Visitor();
				visitor.setUserName(username);
				visitor.setFirstName(firstname);
				visitor.setLastName(lastname);
				visitor.setPassword(password);
				visitor.setEmail(email);
				visitor.setDni(dni);
				visitor.setPhoneNumber(phoneNumber);
				visitor.setAddress(address);
				servicio.createVisitor(visitor);
			}

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
			view.setViewName("register.jsp");
		}

		return view;
	}

}
