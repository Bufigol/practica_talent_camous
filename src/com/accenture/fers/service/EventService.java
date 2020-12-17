package com.accenture.fers.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.fers.dao.EventDAO;
import com.accenture.fers.entity.Event;

/**
 *
 * Implementaci�n de EventService
 *
 * @author Tecnil�gica
 *
 * @version 1.1
 *
 */
@Service("eventService")
public class EventService implements EventFacade {

	EventDAO eventDAO = new EventDAO();

	public EventService() {

	}

	/**
	 * Servicio que devuelve la lista completa de eventos
	 *
	 * @return Colecci�n con todos los eventos
	 *
	 */
	public Set<Event> getAllEvents() {
		// Devuelve todos los eventos
		return eventDAO.findAll();
	}

}
