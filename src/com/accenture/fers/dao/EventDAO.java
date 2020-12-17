package com.accenture.fers.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.fers.entity.Event;

/**
 *
 * Class in which queries are made to the database related to the search for
 * Events
 *
 * @author f.vasquez.tort
 *
 * @version 2.0
 */
@Repository
public class EventDAO implements IEventDAO {

	@PersistenceContext
	EntityManager emanager;

	
	public EventDAO() {

	}

	/**
	 * 
	 * Method used for a general search of all the available events in the database.
	 *
	 * @return A List with all the available events.
	 * 
	 */
	public Set<Event> findAll() {
		Set<Event> events = null;
		Query queryConsulta = emanager.createQuery("SELECT e FROM Event e");
		Collection<Event> listevents = queryConsulta.getResultList();
		events = listevents.stream().collect(Collectors.toSet());
		return events;
	}

	/**
	 * Method that searches the database for a specific event given its id.
	 *
	 * @param eventId, id of the event that needs to be searched.
	 * @return the event that was searched in case it was found, null otherwise.
	 * 
	 */
	public Event findOne(int eventId) {
		Event eventFound = null;

		Query queryConsulta = emanager.createQuery("SELECT e FROM Event e WHERE e.id=?1");
		queryConsulta.setParameter(1, eventId);
		List<Event> resultados = queryConsulta.getResultList();
		eventFound = resultados.get(0);
		return eventFound;
	}

	/**
	 * 
	 * Method that adds a new event to the database
	 * 
	 * @param event, The evento to be added.
	 * 
	 */

	@Transactional
	public void save(Event myEvent) {
		emanager.merge(myEvent);
	}

}
