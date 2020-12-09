package com.accenture.fers.dao;

import java.util.Set;

import com.accenture.fers.entity.Event;


/**
 * 
 * Interface IEventDAO
 * No hay atributos en una Interface, podría haber constantes
 * Todos los métodos son abstractos, por tanto todas las clases 
 * que hereden de ella tendrán que implementar todos los métodos
 *
 * @author Tecnilógica
 *
 * @version 1.0
 * 
 */
public interface IEventDAO {

	/**
	 * 
	 * Lista todos los eventos creados
	 * @return colección con todos los eventos
	 * 
	 */
	Set<Event> findAll();

	/**
	 * 
	 * Busca un evento por su eventId
	 * @param eventId
	 * @return Event
	 * 
	 */
	Event findOne(int eventId);

	/**
	 * 
	 * Actualiza los eventos
	 * @param Event
	 * 
	 */
	void save(Event event);
}
