package com.accenture.fers.service;

import java.util.Set;

import com.accenture.fers.dao.EventDAO;
import com.accenture.fers.dao.IEventDAO;
import com.accenture.fers.dao.IVisitorDAO;
import com.accenture.fers.dao.VisitorDAO;
import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;

/**
 *
 * Implementación de VisitorService
 *
 * @author Tecnilógica
 *
 * @version 1.0
 */
public class VisitorService implements VisitorFacade {

	private IVisitorDAO visitorDAO = new VisitorDAO();

	private IEventDAO eventDAO = new EventDAO();

	/**
	 * 
	 * Servicio que crea un Visitor si no existe
	 *
	 * @param visitor
	 * @return boolean
	 * 
	 */
	public boolean createVisitor(Visitor visitor) {
		boolean flag = false;
		
		// si el username está disponible y es correcto se crea el visitor
		String username = visitor.getUserName();
		
		if (visitorDAO.findByUserName(username) == null) {
			visitorDAO.save(visitor);
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * Servicio que devuelve un Visitor completo
	 * si el visitor que se le pasa se corresponde
	 * con un userName ya registrado
	 *
	 * @param visitor (username)
	 * @return visitor encontrado o null si no lo encuentra
	 */
	public Visitor searchUser(Visitor visitor) {
		// Busca el visitor por userName
		Visitor visitorFound = visitorDAO.findByUserName(visitor.getUserName());

		// si lo encuentra comprueba la contraseña
		if (visitorFound != null) {
			if (!visitorFound.getPassword().equals(visitor.getPassword())) {
				// Lanza la excepción con un mensaje personalizado
				throw new FERSGenericException("Invalid username/password");
			}

		}
		return visitorFound;
	}

	/**
	 * Servicio que registra un visitor a un evento
	 * Este método reduce en uno el número de asientos
	 * disponibles del evento
	 * 
	 * @param visitor
	 * @param eventId
	 * 
	 */
	public void registerVisitorToEvent(Visitor visitor, int eventId) {
		// Buscamos evento por su eventId
		Event event = eventDAO.findOne(eventId);
		// Si hay asientos disponibles
		if (event.getSeatsAvailable() > 0) {
			boolean registrado = false;

			// comprueba si el visitor ya está registrado al evento
			Set<Event> eventsRegistered = visitor.getRegisteredEvents();
			if (eventsRegistered != null) {
				for (Event eventVisitor : eventsRegistered) {
					if (eventVisitor.getEventId() == eventId) {
						registrado = true;
					}
				}
			}
			// Si no está registrado el visitor lo registra
			if (!registrado) {
				int actual = event.getSeatsAvailable();
				event.setSeatsAvailable(actual - 1);

				visitor.getRegisteredEvents().add(event);
				visitorDAO.updateVisitor(visitor);

				//actualiza los asientos del evento
				eventDAO.save(event);
			} else {
				// Lanza la excepción con un mensaje personalizado
				throw new FERSGenericException("User already Registered for the EVENT!");
			}
		} else {
			// Lanza la excepción con un mensaje personalizado
			throw new FERSGenericException("No available seats");
		}
	}

	/**
	 * 
	 * Servicio que devuelve la lista de eventos
	 * 
	 * @param visitor
	 * @return
	 * 
	 */
	public Set<Event> showRegisteredEvents(Visitor visitor) {
		// devuelve los eventos del visitor
		return visitor.getRegisteredEvents();
	}

	/**
	 * 
	 * Servicio que actualiza la info de un visitor
	 * 
	 * @param visitor
	 * @return  int --> 1 si se actualizó correctamente, 0 si no
	 * 
	 */
	public int updateVisitorDetails(Visitor visitor) {
		// actualiza los datos del visitor
		return visitorDAO.updateVisitor(visitor);
	}

	/**
	 * 
	 * Servicio que actualiza la password de un visitor
	 * 
	 * @param visitor
	 * @return int --> 1 si se actualizó correctamente, 0 si no
	 * 
	 */
	public int changePassword(Visitor visitor) {
		// actualiza la password
		return visitorDAO.updateVisitor(visitor);
	}

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
	public void unregisterVisitorToEvent(Visitor visitor, int eventId) {
		// busca el evento por su eventId
		Event event = eventDAO.findOne(eventId);
		boolean registrado = false;

		// comprueba si el visitor ya está registrado al evento
		Set<Event> eventsRegistered = visitor.getRegisteredEvents();
		if (eventsRegistered != null) {
			for (Event eventVisitor : eventsRegistered) {
				if (eventVisitor.getEventId() == eventId) {
					registrado = true;
					break;
				}
			}
		}
		//si el visitor está registrado elimina su registro
		if(registrado){
			visitor.getRegisteredEvents().remove(event);

			visitorDAO.updateVisitor(visitor);

			// se incrementa en uno los asientos disponibles
			int actual = event.getSeatsAvailable();
			event.setSeatsAvailable(actual + 1);
			eventDAO.save(event);
		}
	}

	/**
	 * 
	 * Servicio que chequea si un username está disponible para usarse
	 * @param String username
	 * @return boolean
	 * 
	 */
	public boolean searchUserName(String userName) {
		boolean success = false;
		// busca visitor por su username
		Visitor visitor = visitorDAO.findByUserName(userName);
		if (visitor != null) {
			success = true;
		}
		return success;
	}

}
