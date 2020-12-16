package com.accenture.fers.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.accenture.fers.entity.Event;

/**
 *
 * EventDAO
 *
 * @author Tecnilógica
 *
 * @version 1.0
 */
@Repository
public class EventDAO implements IEventDAO {
	@PersistenceContext
	EntityManager emanager;

	private static Set<Event> events;

	public EventDAO() {
	}

	/**
	 * 
	 * Retorna la lista de eventos
	 *
	 * @return colección con la lista de eventos
	 * 
	 */
	public Set<Event> findAll() {
		EventDAO.events = null;
		
		Query queryConsulta = emanager.createQuery("SELECT e FROM Event e");
		List<Event> eventos = queryConsulta.getResultList();
		for (Event event : eventos) {
			EventDAO.events.add(event);
		}
		return EventDAO.events;
	}

	/**
	 * Retorna un evento si existe
	 *
	 * @param eventId, id del evento
	 * @return Event completo o con null
	 * 
	 */
	public Event findOne(int eventId) {
		
		Event eventFound = null;
		for (Event event : events) {
			if (event.getEventId() == eventId) {
				eventFound = event;
			}
		}
		return eventFound;
	}

	/**
	 * 
	 * Añade un evento
	 * 
	 * @param event, el evento
	 * 
	 */
	public void save(Event myEvent) {
		for (Event event : events) {
			if (event.getEventId() == event.getEventId()) {
				event = myEvent;
			}
		}
	}

}
