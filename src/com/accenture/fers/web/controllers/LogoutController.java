package com.accenture.fers.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController extends HttpServlet implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view = "index.jsp";
		request.getSession().invalidate();
		return view;
	}

}
