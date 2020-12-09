package com.accenture.fers.entity;

import java.util.Set;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.IConstantes;
import com.accenture.fers.utils.Validador;

/**
 * @Author Tecnilógica
 *
 * @version v1.1
 *
 *          Clase Visitor que hereda de la clase People para registrar a los
 *          visitantes de la aplicación
 *
 */

public class Visitor extends People {

	private int visitorId;

	private String userName;

	private String password;

	private Set<Event> registeredEvents;

	public Visitor() {

	}

	/**
	 * @param visitorId
	 * @param userName
	 * @param password
	 * @param registeredEvents
	 */
	public Visitor(String address, String firstName, String lastName, String email, String phoneNumber, String dni,
			int visitorId, String userName, String password, Set<Event> registeredEvents) {
		super(address, firstName, lastName, email, phoneNumber, dni);
		try {
			this.setVisitorId(visitorId);
			this.setUserName(userName);
			this.setPassword(password);
			this.setRegisteredEvents(registeredEvents);
		} catch (FERSGenericException e) {
			// TODO: handle exception
		}
	}

	/**
	 * Constructor that copies all information from another Visitor object,
	 * remaining the same information but in different memory spaces.
	 * 
	 * @param event Reference event to use to create the desired copy.
	 * @author f.vasquez.tort
	 * @version v1:The getter methods of the visitor object entered as a parameter
	 *          are used so that what is obtained can be used as input parameters of
	 *          the setter methods of the new object that is being created, since
	 *          these methods have implemented the different restrictions of each
	 *          parameter of the class. It is done in this way, to ensure that the
	 *          parameters continue to comply with all the restrictions of each of
	 *          them, in case they have been modified from the moment the reference
	 *          visitor object(the one used as a parameter) was created
	 */
	public Visitor(Visitor visitor) {
		if (visitor != null) {
			this.setAddress(visitor.getAddress());
			this.setFirstName(visitor.getFirstName());
			this.setLastName(visitor.getLastName());
			this.setEmail(visitor.getEmail());
			this.setPhoneNumber(visitor.getPhoneNumber());
			this.setDni(visitor.getDni());
			this.setVisitorId(visitor.getVisitorId());
			this.setUserName(visitor.getUserName());
			this.setPassword(visitor.getPassword());
			this.setRegisteredEvents(visitor.getRegisteredEvents());
		}
	}

	// Getters y Setters
	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if (Validador.checkStringLength(userName, IConstantes.MIN_USERNAME, IConstantes.MAX_USERNAME)) {
			this.userName = userName;
		} else {
			throw new FERSGenericException(IConstantes.ERM_013);
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (Validador.checkPassword(password, IConstantes.MIN_PWD, IConstantes.MAX_PWD)) {
			this.password = password;
		} else {
			throw new FERSGenericException(IConstantes.ERM_014);
		}

	}

	public Set<Event> getRegisteredEvents() {
		return registeredEvents;
	}

	public void setRegisteredEvents(Set<Event> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registeredEvents == null) ? 0 : registeredEvents.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + visitorId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Visitor other = (Visitor) obj;
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (registeredEvents == null) {
			if (other.registeredEvents != null) {
				return false;
			}
		} else if (!registeredEvents.equals(other.registeredEvents)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		if (visitorId != other.visitorId) {
			return false;
		}
		return true;
	}

}
