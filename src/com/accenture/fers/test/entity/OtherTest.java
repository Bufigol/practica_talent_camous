package com.accenture.fers.test.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.accenture.fers.utils.IConstantes;
import com.accenture.fers.utils.Validador;

/**
 * @author f.vasquez.tort
 *
 */
class OtherTest {

	@Test
	void testCheckEmail() {
		String testValid[] = { "a@a", "fvasquez@aaa.com", "felipe@algo", "aaaaaaa@ad.a" };
		for (String string : testValid) {
			assertTrue(Validador.checkEmail(string, IConstantes.MIN_EMAIL, IConstantes.MAX_EMAIL));
		}
		String testInvalid[] = { randomNumberString(IConstantes.MIN_EMAIL - 1),
				randomNumberString(IConstantes.MIN_EMAIL), "a@a.", "fvas:quez@aaa.com", "felipe@alg(o",
				"aaaaaaa@a;d.a" ,"aaaa@"};
		for (String string : testInvalid) {
			assertFalse(Validador.checkEmail(string, IConstantes.MIN_EMAIL, IConstantes.MAX_EMAIL));
		}

	}

	@Test
	void testCheckPassword() {
		String testValid[] = { randomString(IConstantes.MIN_PWD + 1), randomString(IConstantes.MAX_PWD - 1),
				randomString((IConstantes.MIN_PWD + IConstantes.MAX_PWD) / 2) };
		for (String string : testValid) {
			assertTrue(Validador.checkPassword(string, IConstantes.MIN_PWD, IConstantes.MAX_PWD));
		}
		String testInvalid[] = { null, randomString(IConstantes.MIN_PWD - 1), randomString(IConstantes.MAX_PWD + 1) };
		for (String string : testInvalid) {
			assertFalse(Validador.checkPassword(string, IConstantes.MIN_PWD, IConstantes.MAX_PWD));
		}
	}

	@Test
	void testCheckDNI() {
		String testValid[] = { "53.991.929-G" };
		for (String string : testValid) {
			assertTrue(Validador.checkDNI(string, IConstantes.MIN_DNI, IConstantes.MAX_DNI));
		}
		String testInvalid[] = { "53991929G", "123456789" };
		for (String string : testInvalid) {
			assertFalse(Validador.checkDNI(string, IConstantes.MIN_DNI, IConstantes.MAX_DNI));
		}
	}

	@Test
	void testCheckPhoneNumber() {
		String testValid[] = { "0652095887", "652 095 887", "+34652095887", randomNumberString(IConstantes.MAX_PHONE),
				randomNumberString(IConstantes.MIN_PHONE) };
		for (String string : testValid) {
			assertTrue(Validador.checkPhoneNumber(string, IConstantes.MIN_PHONE, IConstantes.MAX_PHONE));
		}

		String testInvalid[] = { "123456789", randomNumberString(IConstantes.MIN_PHONE - 1),
				randomNumberString(IConstantes.MAX_PHONE + 1) };
		for (String string : testInvalid) {
			assertFalse(Validador.checkPhoneNumber(string, IConstantes.MIN_PHONE, IConstantes.MAX_PHONE));
		}

	}

	@Test
	void testCheckInteger() {
		assertTrue(Validador.checkInteger(5, 5));
		assertTrue(Validador.checkInteger(6, 5));
		assertTrue(Validador.checkInteger(6, -5));
		assertTrue(Validador.checkInteger(-1, -2));
		assertFalse(Validador.checkInteger(1, 2));
		assertFalse(Validador.checkInteger(0, 2));
		assertFalse(Validador.checkInteger(-1, 2));
		assertFalse(Validador.checkInteger(-3, -2));
	}

	private String randomNumberString(int integer) {
		String exit = "";
		int min = 1;
		int max = 8;
		double random;
		for (int i = 0; i < integer; i++) {
			random = (Math.random() * (max - min + 1) + min);
			exit += String.valueOf((int) Math.ceil(random));
		}
		return exit;
	}

	private String randomString(int integer) {
		// Array where whe get the letters
		String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
				"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", " " };
		int min = 0; // minimum of the random number
		int max = letters.length - 1; // maximum of the random number
		int random; // declaration for storing the random number
		String exit = ""; // initialization the exit value.
		for (int i = 0; i < integer; i++) {
			// Generate a random number and cast it to int form double
			random = (int) (Math.random() * (max - min + 1) + min);
			exit += letters[random]; // get the random letter from the arrya and add it to the exit value
		}
		return exit;
	}
}
