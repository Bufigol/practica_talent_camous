package com.accenture.fers.service;

import java.util.Set;
import com.accenture.fers.entity.Event;

/**
 * Interface EventFacade
 *
 * @author Tecnilógica
 *
 * @version 1.1
 *
 */
public interface EventFacade {

	/**
	 *  Servicio que devuelve la lista completa de eventos
	 *
	 * @return Colección con todos los eventos
	 *
	 */
	public Set<Event> getAllEvents();

}
