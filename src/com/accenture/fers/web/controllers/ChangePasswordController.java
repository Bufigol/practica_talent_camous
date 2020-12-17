package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.fers.entity.Visitor;
import com.accenture.fers.service.VisitorFacade;
import com.accenture.fers.service.VisitorService;

@Controller("/changePassword.do")
public class ChangePasswordController implements IController {
	@Autowired
	VisitorFacade servicio;

	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/updateVisitorPassword.jsp");
		try {
			// Recuperar los parametros de la request
			String usuario = request.getParameter("visitorname");
			String password = request.getParameter("currentPassword");

			// Crear una instancia del objeto Visitor
			Visitor visitor = new Visitor();

			// Asignamos valores a esta instancia
			visitor.setUserName(usuario);
			visitor.setPassword(password);

			// llamamos al servico para recuperar los datos del visitante
			visitor = servicio.searchUser(visitor);

			// obtengo la nueva password y la actualizamos
			String newPasword = request.getParameter("newPassword");
			visitor.setPassword(newPasword);

			if (servicio.changePassword(visitor) == 1) {
				request.getSession().invalidate();
				view.setViewName("/index.jsp");
			}

		} catch (Exception error) {
			// Guardo en la request el mensaje de error
			request.setAttribute("error", error.getMessage());
		}
		return view;
	}

}
