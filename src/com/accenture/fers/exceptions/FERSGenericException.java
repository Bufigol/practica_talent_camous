package com.accenture.fers.exceptions;

/**
 *
 * @author Tecnilógica
 *
 * @version 1.1
 * 
 *          Clase personalizada para las excepciones de la aplicación
 * 
 */

@SuppressWarnings("serial")
public class FERSGenericException extends RuntimeException {

	public FERSGenericException(String message, Throwable object) {
		super(message, object);
	}

	public FERSGenericException(String message) {
		super(message);
	}

}
