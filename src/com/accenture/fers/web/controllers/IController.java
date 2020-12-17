package com.accenture.fers.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface IController {
	/**
	 * An interface for defining the request process method needed for Controllers:
	 * 
	 * @param request
	 * @param response
	 * @return the name of the view (html/jsp) that has to generate the response
	 */
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response);
}
