package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;


@Controller("/logoutController.do")
public class LogoutController extends HttpServlet implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view = "index.jsp";
		request.getSession().invalidate();
		return view;
	}

}
