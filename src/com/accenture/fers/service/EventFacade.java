package com.accenture.fers.service;

import java.util.Set;
import com.accenture.fers.entity.Event;

/**
 * Interface EventFacade
 *
 * @author Tecnil�gica
 *
 * @version 1.1
 *
 */
public interface EventFacade {

	/**
	 *  Servicio que devuelve la lista completa de eventos
	 *
	 * @return Colecci�n con todos los eventos
	 *
	 */
	public Set<Event> getAllEvents();

}
