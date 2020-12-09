package com.accenture.fers.dao;

import java.util.Set;

import com.accenture.fers.entity.Event;


/**
 * 
 * Interface IEventDAO
 * No hay atributos en una Interface, podr�a haber constantes
 * Todos los m�todos son abstractos, por tanto todas las clases 
 * que hereden de ella tendr�n que implementar todos los m�todos
 *
 * @author Tecnil�gica
 *
 * @version 1.0
 * 
 */
public interface IEventDAO {

	/**
	 * 
	 * Lista todos los eventos creados
	 * @return colecci�n con todos los eventos
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
