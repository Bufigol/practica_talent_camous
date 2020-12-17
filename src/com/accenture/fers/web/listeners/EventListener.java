package com.accenture.fers.web.listeners;

import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.fers.entity.Event;
import com.accenture.fers.service.EventService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Application Lifecycle Listener implementation class Listener Clase que
 * determina qu� ocurre cuando el Servlet se destruye o se crea, recuper�ndose
 * en este �ltimo caso los eventos que se guardar�n en el Servlet Context para
 * poder ser usados por la aplicaci�n
 *
 */
@WebListener // Anotaci�n para configurar el listener
public class EventListener implements ServletContextListener {

	/**
	 * Default constructor (constructor vac�o)
	 */
	public EventListener() {

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent) En este
	 *      m�todo se pone lo que se quiere que haga cuando se destruye el servlet
	 * 
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent) En este
	 *      m�todo se indica lo que se quiere que haga cuando el servlet se crea o
	 *      inicializa
	 *
	 *      Cuando se crea el servlet se recuperan todos los eventos y se guardan en
	 *      el Servlet Context para usarlos en la aplicaci�n
	 */

	// Por standar de Java y de JPA, es necesario utilizar la interface para crear
	// la bean
	@Autowired
	EventService eventService;

	public void contextInitialized(ServletContextEvent servletContextEvent) {

		// Se crea el contendor ApplicationContext (que maneja las Beans) para poder
		// recuperar la bean de eventService
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(servletContextEvent.getServletContext());

		eventService = (EventService) ac.getBean("eventService");

		// Se recuperan todos los eventos con el m�todo getAllEvents del EventService
		Set<Event> listaEventos = eventService.getAllEvents();

		// Coger esa lista de eventos y garadarla en el ServletContext
		servletContextEvent.getServletContext().setAttribute("listaEventos", listaEventos);

	}
}
