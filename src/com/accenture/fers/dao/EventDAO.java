package com.accenture.fers.dao;

import java.util.HashSet;
import java.util.Set;

import com.accenture.fers.entity.Event;

/**
*
* EventDAO
*
* @author Tecnilógica
*
* @version 1.0
*/
public class EventDAO implements IEventDAO{

	private static Set<Event> events;

	static{
		events = new HashSet<Event>();
		Event event1 = new Event();
		event1.setEventId(1);
		event1.setName("Champions League");
		event1.setDescription("Juventus - Liverpool");
		event1.setEventType("Deportes");
		event1.setPlace("Munich");
		event1.setDuration("2 horas");
		event1.setSeatsAvailable(1);

		Event event2 = new Event();
		event2.setEventId(2);
		event2.setName("Michael Jackson");
		event2.setDescription("El rey del Pop en concierto");
		event2.setEventType("Cultura");
		event2.setPlace("Zaragoza");
		event2.setDuration("3 horas");
		event2.setSeatsAvailable(200);

		Event event3 = new Event();
		event3.setEventId(3);
		event3.setName("Borealia");
		event3.setDescription("Aurora Boreal en Alaska");
		event3.setEventType("Ocio");
		event3.setPlace("Alaska");
		event3.setDuration("Una semana");
		event3.setSeatsAvailable(20);

		Event event4 = new Event();
		event4.setEventId(4);
		event4.setName("Globos");
		event4.setDescription("Paseo en globo en Pirineos");
		event4.setEventType("Ocio");
		event4.setPlace("Lérida");
		event4.setDuration("Un día");
		event4.setSeatsAvailable(10);

		Event event5 = new Event();
		event5.setEventId(5);
		event5.setName("Guggenheim");
		event5.setDescription("Visita al Guggenheim");
		event5.setEventType("Cultura");
		event5.setPlace("Bilbao");
		event5.setDuration("4 horas");
		event5.setSeatsAvailable(3);

		events.add(event1);
		events.add(event2);
		events.add(event3);
		events.add(event4);
		events.add(event5);
	}

	public EventDAO(){}

	/**
	 * 
	 * Retorna la lista de eventos
	 *
	 * @return colección con la lista de eventos
	 * 
	 */
	public Set<Event> findAll() {
		return events;
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
