package com.accenture.fers.entity;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.IConstantes;
import com.accenture.fers.utils.Validador;

/**
 * Class that represents the potential attendees of an event.
 * 
 * @author f.vasquez.tort
 *
 * @version v1.1 First version of the class where the first version of the
 *          restrictions on its parameters have been added.
 *
 */

public class People {

	private String address;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String dni;

	// Constructores
	/**
	 * Empty constructor. Its use is discouraged
	 * 
	 * @author f.vasquez.tort
	 * @version v1
	 */
	public People() {

	}

	/**
	 * Main constructor of the class, where all the information of the event class
	 * is obtained.
	 * 
	 * @param address
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param dni
	 */
	public People(String address, String firstName, String lastName, String email, String phoneNumber, String dni) {
		try {
			this.setAddress(address);
			this.setFirstName(firstName);
			this.setLastName(lastName);
			this.setEmail(email);
			this.setPhoneNumber(phoneNumber);
			this.setDni(dni);
		} catch (FERSGenericException e) {

		}
	}

	public People(People people) {
		if (people != null) {
			this.setAddress(people.getAddress());
			this.setFirstName(people.getFirstName());
			this.setLastName(people.getLastName());
			this.setEmail(people.getEmail());
			this.setPhoneNumber(people.getPhoneNumber());
			this.setDni(people.getDni());
		}
	}

	// Getters y Setters
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (Validador.checkStringLength(address, IConstantes.MIN_ADDRESS, IConstantes.MAX_ADDRESS)) {
			this.address = address;
		} else {
			throw new FERSGenericException(IConstantes.ERM_017);
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (Validador.checkStringLength(firstName, IConstantes.MIN_FIRST_NAME, IConstantes.MAX_FIRST_NAME)) {
			this.firstName = firstName;
		} else {
			throw new FERSGenericException(IConstantes.ERM_015);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (Validador.checkStringLength(lastName, IConstantes.MIN_LAST_NAME, IConstantes.MAX_LAST_NAME)) {
			this.lastName = lastName;
		} else {
			throw new FERSGenericException(IConstantes.ERM_016);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (Validador.checkEmail(email, IConstantes.MIN_EMAIL, IConstantes.MAX_EMAIL)) {
			this.email = email;
		} else {
			throw new FERSGenericException(IConstantes.ERM_011);
		}

	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (Validador.checkPhoneNumber(phoneNumber, IConstantes.MIN_PHONE, IConstantes.MAX_PHONE)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new FERSGenericException(IConstantes.ERM_010);
		}

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (Validador.checkDNI(dni, IConstantes.MIN_DNI, IConstantes.MAX_DNI)) {
			this.dni = dni;
		} else {
			throw new FERSGenericException(IConstantes.ERM_012);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		People other = (People) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (dni == null) {
			if (other.dni != null) {
				return false;
			}
		} else if (!dni.equals(other.dni)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		return true;
	}

}
