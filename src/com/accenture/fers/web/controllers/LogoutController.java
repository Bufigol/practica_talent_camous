package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller("/logoutController.do")
public class LogoutController extends HttpServlet implements IController {

	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("index.jsp");
		request.getSession().invalidate();
		return view;
	}

}
