package com.accenture.fers.service;

import java.util.Set;

import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;

/**
 * Interface VisitorFacade
 *
 * @author Tecnilógica
 *
 * @version 1.1
 */

public interface VisitorFacade {
	/**
	 * 
	 * Servicio que crea un Visitor si no existe
	 * @param visitor
	 * @return boolean
	 * 
	 */
	public boolean createVisitor(Visitor visitor);

	/**
	 * 
	 * Servicio que devuelve un Visitor completo
	 * si el visitor que se le pasa se corresponde
	 * con un userName ya registrado
	 * 
	 * @param visitor
	 * @return visitor found
	 * 
	 */
	public Visitor searchUser(Visitor visitor);

	/**
	 * Servicio que registra un visitor a un evento
	 * Este método reduce en uno el número de asientos
	 * disponibles del evento
	 * 
	 * @param visitor
	 * @param eventId
	 * 
	 */
	public void registerVisitorToEvent(Visitor visitor, int eventId);
	
	/**
	 * 
	 * Servicio que devuelve la lista de eventos
	 * @param visitor
	 * @return
	 * 
	 */
	public Set<Event> showRegisteredEvents(Visitor visitor);

	/**
	 * 
	 * Servicio que actualiza la info de un visitor
	 * @param visitor
	 * @return  int --> 1 si se actualizó correctamente, 0 si no
	 * 
	 */
	public int updateVisitorDetails(Visitor visitor);

	/**
	 * 
	 * Servicio que actualiza la password de un visitor
	 * @param visitor
	 * @return int --> 1 si se actualizó correctamente, 0 si no
	 * 
	 */
	public int changePassword(Visitor visitor);
	
	/**
	 * 
	 * Servicio que elimina el registro de un visitor a un evento
	 * Este método incrementa en uno el número de asientos
	 * disponibles del evento
	 * 
	 * @param visitor
	 * @param eventId
	 * 
	 */
	public void unregisterVisitorToEvent(Visitor visitor, int eventid);
	
	/**
	 * 
	 * Servicio que chequea si un username está disponible para usarse
	 * @param String username
	 * @return boolean
	 * 
	 */
	public boolean searchUserName(String userName);
}
