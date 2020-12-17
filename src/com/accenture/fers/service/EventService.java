package com.accenture.fers.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.accenture.fers.dao.EventDAO;
import com.accenture.fers.entity.Event;

/**
 *
 * Implementación de EventService
 *
 * @author Tecnilógica
 *
 * @version 1.1
 *
 */
@Service("eventService")
@EnableTransactionManagement 
public class EventService implements EventFacade {

	EventDAO eventDAO = new EventDAO();

	public EventService() {

	}

	/**
	 * Servicio que devuelve la lista completa de eventos
	 *
	 * @return Colección con todos los eventos
	 *
	 */
	public Set<Event> getAllEvents() {
		// Devuelve todos los eventos
		return eventDAO.findAll();
	}

}
