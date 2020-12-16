package com.accenture.fers.dao;

import java.util.List;
import java.util.Set;

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
@EnableTransactionManagement
public class EventDAO implements IEventDAO {
	@PersistenceContext
	EntityManager emanager;

	private static Set<Event> events;
	private int lastID;

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
		EventDAO.events.clear();
		this.lastID = 0;
		Query queryConsulta = emanager.createQuery("SELECT e FROM Event e");
		List<Event> eventos = queryConsulta.getResultList();
		for (Event event : eventos) {
			EventDAO.events.add(event);
			this.lastID++;
		}
		return EventDAO.events;
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
		Query queryConsulta = emanager.createNativeQuery(
				"INSERT INTO events(id,name,description,places,duration,event_type,seats_available) VALUES (? , ? , ? , ? , ? , ? , ?)");
		if (myEvent.getEventId() <= this.lastID) {
			this.lastID = this.lastID + 1;
			myEvent.setEventId(this.lastID);
		}
		queryConsulta.setParameter(1, myEvent.getEventId());
		queryConsulta.setParameter(2, myEvent.getName());
		queryConsulta.setParameter(3, myEvent.getDescription());
		queryConsulta.setParameter(4, myEvent.getPlace());
		queryConsulta.setParameter(5, myEvent.getDuration());
		queryConsulta.setParameter(6, myEvent.getEventType());
		queryConsulta.setParameter(7, myEvent.getSeatsAvailable());
		queryConsulta.executeUpdate();
	}

}
