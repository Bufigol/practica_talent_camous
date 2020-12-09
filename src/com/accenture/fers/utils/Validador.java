package com.accenture.fers.utils;

/**
 * Class that holds all the diferents validation method to be used in the
 * Project
 * 
 * @author f.vasquez.tort
 * @version v1.1 First version of the validation method that are tested under
 *          the rest of the classes
 */

public class Validador {
	/**
	 * Method that is used to check is and email entered by the user is valid or
	 * not. It's consider valid, if the entered String is formed by letters or
	 * digits, haves one and only one @, and at most one dot('.') and must be after
	 * the @ symbol
	 * 
	 * @param email String that represents the email to be checked
	 * @param min   The minimum length of the possible email.
	 * @param max   The minimum length of the possible email.
	 * @return True if the email complies with all the format constrains, false in
	 *         any other case
	 */
	public static boolean checkEmail(String email, int min, int max) {
		boolean exit = checkStringLength(email, min, max);// variable de salida
		int i = 0;
		Character at = '@';
		int atCount = 0;
		Character[] notAdmitedCharacters = { '(', ')', '[', ']', '\\', ';', ':', ',', '<', '>', ' ' };
		while (exit && i < email.length()) {
			for (Character character : notAdmitedCharacters) {
				if (character.equals(email.charAt(i))) {
					exit = false;
				}

			}
			if (at.equals(email.charAt(i))) {
				atCount++;
			}
			i++;
		}
		if (atCount != 1 || email.endsWith(".")|| email.endsWith("@")) {
			exit = false;
		}
		return exit;
	}

	/**
	 * method of checking the validity of a possible password. For a password to be
	 * valid, it must be composed of numbers or letters, contain no spaces and be
	 * within the allowed character range.
	 * 
	 * @param string The password to be checked.
	 * @param max    The maximum length of the string
	 * @param min    The minimum length of the string
	 * @return True if the entered String is valid, false otherwise.
	 */
	public static boolean checkPassword(String string, int min, int max) {
		boolean exit = true;
		if (string == null) {
			exit = false;
		} else {
			if (string.length() < min || string.length() > max) {
				exit = false;
			}
		}

		return exit;
	}

	public static boolean checkStringLength(String st, int min, int max) {
		boolean exit;
		if ((st != null) && (st.length() >= min) && (st.length() <= max)) {
			exit = true;
		} else {
			exit = false;
		}
		return exit;
	}

	/**
	 * Method for checking the validity of the DNI entered by the user. It is
	 * checked that it is not null, that the text entered has the appropriate length
	 * within the established range, and that the security character is correct.
	 * 
	 * @param dni The input parameter must have the format xx.xxx.xxx-C, where 'x'
	 *            must be a digit and C is the security character.
	 * @param min
	 * @param max
	 * @return true if the input parameter meets the requirements for length,
	 *         format, and the security character is correct, and false otherwise.
	 */
	public static boolean checkDNI(String dni, int min, int max) {
		boolean exit; // used in the return statment
		if (dni == null) {
			exit = false;
		} else {
			if (dni.length() < min || dni.length() > max) {
				exit = false;
			} else {
				exit = true;
			}
		}
		int i = 0;
		String DNIsinLetra = "";// used in the furute for convert it to a number an check the letter
		dni = dni.toUpperCase(); // just in case, make all upper case for handeling
		char aComprobar;
		/*
		 * Check that all characters, except the last one, comply with the required
		 * format 991.929-G 345678901
		 */
		while (exit && i < (IConstantes.MAX_DNI - 1)) {
			aComprobar = dni.charAt(i);
			if (Character.isDigit(aComprobar)) {
				DNIsinLetra += dni.charAt(i);
				exit = true;
			} else {
				if ((esPunto(dni.charAt(i)) && ((i == 2) || (i == 6))) || (esGuion(dni.charAt(i)) && (i == 10))) {
					exit = true;
				} else {
					exit = false;
				}

			}
			i++;
		}
		/*
		 * check that the last character is the security letter
		 */
		if (exit && (dni.length() == IConstantes.MAX_DNI)
				&& (!checkLetraDNI(DNIsinLetra, dni.charAt(IConstantes.MAX_DNI - 1)))) {
			exit = false;
		}

		return exit;
	}

	/**
	 * Method that seeks to check that the input parameter is within the established
	 * range and that it has a telephone number format. It is considered to have a
	 * phone number format if it is within the allowed range and begins with a digit
	 * or with a + symbol.
	 * 
	 * @param string Input parameter to check if it is indeed a telephone number.
	 * @param min    Parameter where the minimum length that the telephone number to
	 *               verify is established.
	 * @param max    Parameter where the maximum length that the telephone number to
	 *               check must have is established.
	 * @return true if the input parameter to be checked is not null, it complies
	 *         with the length range and it is verified that the first character of
	 *         the parameter is a + sign or a digit. False in any other case.
	 */
	public static boolean checkPhoneNumber(String string, int min, int max) {
		boolean exit = true;
		if (string == null) {
			exit = false;
		} else {
			if (string.length() < min || string.length() > max) {
				exit = false;
			}
		}
		Character space = ' ';
		Character plus = '+';
		int i = 1;
		if (!(Character.isDigit(string.charAt(0))) && !(space.equals(string.charAt(0)))
				&& !(plus.equals(string.charAt(0)))) {
			exit = false;
		}
		while (exit && i < string.length()) {
			if (!(Character.isDigit(string.charAt(i))) && !(space.equals(string.charAt(i)))) {
				exit = false;
			}
			i++;
		}
		return exit;
	}

	/**
	 * Method used to check if a specific integer is greather or equal to an
	 * specific value.
	 * 
	 * @param integer the Value to compare
	 * @param min     The minimun that the integer have to meet.
	 * @return true if is greater of equal to the minimun, false in eny other case.
	 */
	public static boolean checkInteger(int integer, int min) {
		boolean exit = false;
		if (integer >= min) {
			exit = true;
		}
		return exit;
	}

	/**
	 * Private method used within the
	 * {@link #checkDNI(String dni, int min, int max)} method to check if a specific
	 * character is '-' or not.
	 * 
	 * @param c Input character that it is checked whether or not this parameter is
	 *          a '-'
	 * @return true if the input parameter is '-', false in any other case.
	 * @see {@link #checkDNI(String dni, int min, int max)}
	 */
	private static boolean esGuion(char c) {
		Character guion = '-';
		boolean exit;
		if (guion.equals(c)) {
			exit = true;
		} else {
			exit = false;
		}
		return exit;

	}

	/**
	 * Private method used within the
	 * {@link #checkDNI(String dni, int min, int max)} method to check if a specific
	 * character is '.' or not.
	 * 
	 * @param c Input character that it is checked whether or not this parameter is
	 *          a '.'
	 * @return true if the input parameter is '.', false in any other case.
	 * @see {@link #checkDNI(String dni, int min, int max)}
	 */
	private static boolean esPunto(char c) {
		Character punto = '.';
		boolean exit;
		if (punto.equals(c)) {
			exit = true;
		} else {
			exit = false;
		}
		return exit;

	}

	/**
	 * Private method used to check if the security letter of the DNI entered by the
	 * user is correct. On the one hand, an input String is expected that will be
	 * converted into a number to calculate the security letter. This input String
	 * represents the DNI without letters, periods or hyphens, that is, only the
	 * numbers. On the other hand, a character that represents the security letter
	 * entered by the user is expected.
	 * 
	 * @param string Input parameter that represents the numbers entered by the user
	 *               on which the security letter will be calculated.
	 * @param c      Input character entered by the user, which will be checked if
	 *               it is correct or not.
	 * @return True if the letter entered by the user is the expected one, false in
	 *         any other case.
	 * 
	 * @see {@link #checkDNI(String dni, int min, int max)}
	 */
	private static boolean checkLetraDNI(String string, char c) {
		boolean exit;
		char[] posibleLetras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };
		int posLetra = Integer.parseInt(string) % 23;
		Character checkLetra = posibleLetras[posLetra];
		if (checkLetra.equals(c)) {
			exit = true;
		} else {
			exit = false;
		}
		return exit;
	}

}
