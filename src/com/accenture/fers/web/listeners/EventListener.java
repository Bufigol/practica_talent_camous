package com.accenture.fers.web.listeners;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.accenture.fers.entity.Event;
import com.accenture.fers.service.EventFacade;
import com.accenture.fers.service.EventService;

/**
 * EventListener es una implementaci�n de la clase ServletContextListener En la
 * inicializaci�n cargaremos la lista de todos los eventos de la aplicaci�n
 *
 */
@WebListener
public class EventListener implements ServletContextListener {

	/**
	 * Contructor por defecto o vac�o
	 */
	public EventListener() {

	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		/*
		 * Quiero que coja todos los elementos de EventDAO, los guarde en una lista y la
		 * meta en un ServletContext para tenerla accesible en el Portal.jsp Se usa con
		 * todos las variables que pertenezcan al ApplicatioScope S�lo hay 1
		 * ServletContext por aplicaci�n. Se crea antes de que arranque la misma. Una
		 * vez creado ser� utilizado por todos los servlets y jsps de la aplicaci�n.
		 */

		// Me creo lista para albergar todos los eventos globales
		Set<Event> listaEventos = new HashSet<Event>();
		EventFacade eventService = new EventService();

		// Relleno la lista usando el servicio
		listaEventos = eventService.getAllEvents();

		// Los meto en el ServletContext
		event.getServletContext().setAttribute("lista_Eventos", listaEventos);
	}

}
