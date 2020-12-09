package com.accenture.fers.service;

import java.util.Set;

import com.accenture.fers.dao.EventDAO;
import com.accenture.fers.dao.IEventDAO;
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
public class EventService implements EventFacade{

	IEventDAO eventDAO = new EventDAO();

	/**
	 *  Servicio que devuelve la lista completa de eventos
	 *
	 * @return Colecci�n con todos los eventos
	 *
	 */
	public Set<Event> getAllEvents() {
		//Devuelve todos los eventos
		return eventDAO.findAll();
	}

}
