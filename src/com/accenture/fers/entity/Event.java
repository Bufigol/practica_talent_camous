package com.accenture.fers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.IConstantes;
import com.accenture.fers.utils.Validador;

/**
 * 
 * Class that represents the possible events that a person can attend
 * 
 * @author f.vasquez.tort
 *
 * @version v1.2
 *
 * 
 */

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	private int eventId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "places")
	private String place;

	@Column(name = "duration")
	private String duration;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "seats_available")
	private int seatsAvailable;

	// Constructores
	/**
	 * Empty constructor. Its use is discouraged
	 * 
	 * @author f.vasquez.tort
	 * @version v1
	 */
	public Event() {

	}

	/**
	 * Main constructor of the class, where all the information of the event class
	 * is obtained.
	 * 
	 * @param eventId        Integer that represents the primary key within the
	 *                       database, which uniquely identifies the event
	 * @param name           String that represents the name that is given to the
	 *                       event and that is easy to identify by the attendees.
	 * @param description    String that represents the description of the event and
	 *                       that gives detailed information about it.
	 * @param place          String that represents the location of the event.
	 * @param duration       String that gives an idea of the duration of the event.
	 * @param eventType      String that represents what type the event is.
	 * @param seatsAvailable Integer that gives information on how many people can
	 *                       attend the event.
	 * @author f.vasquez.tort
	 * @version v1: The setter methods of each parameter are used, so that in this
	 *          way the input information of each parameter can be validated
	 */
	public Event(int eventId, String name, String description, String place, String duration, String eventType,
			int seatsAvailable) {
		this.setEventId(eventId);
		this.setName(name);
		this.setDescription(description);
		this.setPlace(place);
		this.setDuration(duration);
		this.setEventType(eventType);
		this.setSeatsAvailable(seatsAvailable);
	}

	/**
	 * Constructor that copies all information from another event object, remaining
	 * the same information but in different memory spaces.
	 * 
	 * @param event Reference event to use to create the desired copy.
	 * @author f.vasquez.tort
	 * @version v1:The getter methods of the event entered as a parameter are used
	 *          so that what is obtained can be used as input parameters of the
	 *          setter methods of the new object that is being created, since these
	 *          methods have implemented the different restrictions of each
	 *          parameter of the class. It is done in this way, to ensure that the
	 *          parameters continue to comply with all the restrictions of each of
	 *          them, in case they have been modified from the moment the reference
	 *          event(the one used as a parameter) was created
	 */
	public Event(Event event) {
		if (event != null) {
			this.setEventId(event.getEventId());
			this.setName(event.getName());
			this.setDescription(event.getDescription());
			this.setPlace(event.getPlace());
			this.setDuration(event.getDuration());
			this.setEventType(event.getEventType());
			this.setSeatsAvailable(event.getSeatsAvailable());
		}
	}

	// Getters y Setters
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (Validador.checkStringLength(name, IConstantes.MIN_EVENT_NAME, IConstantes.MAX_EVENT_NAME)) {
			this.name = name;
		} else {
			throw new FERSGenericException(IConstantes.ERM_018);
		}

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (Validador.checkStringLength(description, IConstantes.MIN_EVENT_DESCRIPTION,
				IConstantes.MAX_EVENT_DESCRIPTION)) {
			this.description = description;
		} else {
			throw new FERSGenericException(IConstantes.ERM_019);
		}
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		if (Validador.checkStringLength(place, IConstantes.MIN_EVENT_PLACE, IConstantes.MAX_EVENT_PLACE)) {
			this.place = place;
		} else {
			throw new FERSGenericException(IConstantes.ERM_020);
		}
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		if (Validador.checkStringLength(duration, IConstantes.MIN_EVENT_DURATION, IConstantes.MAX_EVENT_DURATION)) {
			this.duration = duration;
		} else {
			throw new FERSGenericException(IConstantes.ERM_021);
		}
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		if (Validador.checkStringLength(eventType, IConstantes.MIN_EVENT_TYPE, IConstantes.MAX_EVENT_TYPE)) {
			this.eventType = eventType;
		} else {
			throw new FERSGenericException(IConstantes.ERM_022);
		}
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		if (Validador.checkInteger(seatsAvailable, IConstantes.MIN_SEATS_AVAILABLE)) {
			this.seatsAvailable = seatsAvailable;
		} else {
			throw new FERSGenericException(IConstantes.ERM_023);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + eventId;
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + seatsAvailable;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Event other = (Event) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (duration == null) {
			if (other.duration != null) {
				return false;
			}
		} else if (!duration.equals(other.duration)) {
			return false;
		}
		if (eventId != other.eventId) {
			return false;
		}
		if (eventType == null) {
			if (other.eventType != null) {
				return false;
			}
		} else if (!eventType.equals(other.eventType)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (place == null) {
			if (other.place != null) {
				return false;
			}
		} else if (!place.equals(other.place)) {
			return false;
		}
		if (seatsAvailable != other.seatsAvailable) {
			return false;
		}
		return true;
	}

}
