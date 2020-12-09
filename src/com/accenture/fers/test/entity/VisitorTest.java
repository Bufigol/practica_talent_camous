package com.accenture.fers.test.entity;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.accenture.fers.entity.Event;
import com.accenture.fers.entity.People;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.IConstantes;

public class VisitorTest {
	Visitor visitor;
	People people;

	@Before
	public void setUp() throws Exception {
		// (String address, String firstName, String lastName, String email, String
		// phoneNumber, String dni,
		// int visitorId, String userName, String password, Set<Event> registeredEvents)
		Set<Event> registeredEvents = new HashSet<Event>();
		visitor = new Visitor("address", "First Name", "Last Name", "email@email.com", "+34652095887", "53.991.929-G",
				1, "f.vasquez", "1234567", registeredEvents);
		people = new People("address", "First Name", "Last Name", "email@email.com", "+34652095887", "53.991.929-G");
	}

	@After
	public void tearDown() throws Exception {
		this.visitor = null;
		this.people = null;
	}

	@Test
	public void testConstructorEntero() {
		try {
			Set<Event> registeredEvents = new HashSet<Event>();
			Visitor visitor = new Visitor("address", "First Name", "Last Name", "email@email.com", "+34652095887",
					"53.991.929-G", 1, "f.vasquez", "1234567", registeredEvents);
			assertEquals(this.visitor, visitor);
		} catch (FERSGenericException e) {
			fail("A crash occurred during event creation");
		}
	}

	@Test
	public void testVisitorVisitor() {
		Visitor visitorCopy = new Visitor(this.visitor);
		assertEquals(this.visitor, visitorCopy);

	}

	@Test
	public void testGetVisitorId() {
		assertEquals(visitor.getVisitorId(), 1);
	}

	@Test
	public void testSetVisitorId() {
		int test = 10;
		visitor.setVisitorId(test);
		assertEquals(visitor.getVisitorId(), test);
	}

	@Test
	public void testGetUserName() {
		assertEquals(visitor.getUserName(), "f.vasquez");
	}

	@Test
	public void testSetUserName() {
		String test = randomString((IConstantes.MIN_USERNAME + IConstantes.MAX_USERNAME) / 2);
		visitor.setUserName(test);
		assertEquals(visitor.getUserName(), test);
	}

	@Test
	public void testGetPassword() {
		String test = "1234567";
		assertEquals(visitor.getPassword(), test);
	}

	@Test
	public void testSetPassword() {
		String test = randomString((IConstantes.MIN_PWD + IConstantes.MAX_PWD) / 2);
		visitor.setPassword(test);
		assertEquals(visitor.getPassword(), test);
	}

	@Test
	public void testConstructorPeopleCompleto() {
		People test = new People(this.visitor.getAddress(), this.visitor.getFirstName(), this.visitor.getLastName(),
				this.visitor.getEmail(), this.visitor.getPhoneNumber(), this.visitor.getDni());
		assertEquals(this.people, test);
	}

	@Test
	public void testPeoplePeople() {
		People test = new People(this.people);
		assertEquals(this.people, test);
	}

	@Test
	public void testGetAddress() {
		String test = "address";
		assertEquals(this.people.getAddress(), test);
		assertEquals(this.visitor.getAddress(), test);
	}

	@Test
	public void testSetAddress() {
		int mean = ((IConstantes.MIN_ADDRESS + IConstantes.MAX_ADDRESS) / 2);
		String test = randomString(mean);
		String test2 = randomString(mean);
		this.people.setAddress(test);
		this.visitor.setAddress(test2);
		assertEquals(this.people.getAddress(), test);
		assertEquals(this.visitor.getAddress(), test2);
	}

	@Test
	public void testGetFirstName() {
		String test = "First Name";
		assertEquals(this.people.getFirstName(), test);
		assertEquals(this.visitor.getFirstName(), test);
	}

	@Test
	public void testSetFirstName() {
		int mean = ((IConstantes.MIN_FIRST_NAME + IConstantes.MAX_FIRST_NAME) / 2);
		String test = randomString(mean);
		String test2 = randomString(mean);
		this.people.setFirstName(test);
		this.visitor.setFirstName(test2);
		assertEquals(this.people.getFirstName(), test);
		assertEquals(this.visitor.getFirstName(), test2);
	}

	@Test
	public void testGetLastName() {
		String test = "Last Name";
		assertEquals(this.people.getLastName(), test);
		assertEquals(this.visitor.getLastName(), test);
	}

	@Test
	public void testSetLastName() {
		int mean = ((IConstantes.MIN_LAST_NAME + IConstantes.MAX_LAST_NAME) / 2);
		String test = randomString(mean);
		String test2 = randomString(mean);
		this.people.setLastName(test);
		this.visitor.setLastName(test2);
		assertEquals(this.people.getLastName(), test);
		assertEquals(this.visitor.getLastName(), test2);
	}

	@Test
	public void testGetEmail() {
		String test = "email@email.com";
		assertEquals(this.visitor.getEmail(), test);
		assertEquals(this.people.getEmail(), test);
	}

	@Test
	public void testSetEmail() {
		String test1 = "a@a";
		String test2 = "valid@email.com";
		this.visitor.setEmail(test1);
		this.people.setEmail(test1);
		assertEquals(this.visitor.getEmail(), test1);
		assertEquals(this.people.getEmail(), test1);
		this.visitor.setEmail(test2);
		this.people.setEmail(test2);
		assertEquals(this.visitor.getEmail(), test2);
		assertEquals(this.people.getEmail(), test2);
	}

	@Test
	public void testGetPhoneNumber() {
		String test = "+34652095887";
		assertEquals(this.visitor.getPhoneNumber(), test);
		assertEquals(this.people.getPhoneNumber(), test);
	}

	@Test
	public void testSetPhoneNumber() {
		String test1 = "+" + randomNumberString((IConstantes.MIN_PHONE + IConstantes.MAX_PHONE) / 2);
		String test2 = randomNumberString((IConstantes.MIN_PHONE + IConstantes.MAX_PHONE) / 2);
		this.visitor.setPhoneNumber(test1);
		this.people.setPhoneNumber(test1);
		assertEquals(this.visitor.getPhoneNumber(), test1);
		assertEquals(this.people.getPhoneNumber(), test1);
		this.visitor.setPhoneNumber(test2);
		this.people.setPhoneNumber(test2);
		assertEquals(this.visitor.getPhoneNumber(), test2);
		assertEquals(this.people.getPhoneNumber(), test2);
	}

	@Test
	public void testGetDni() {
		String test = "53.991.929-G";
		assertEquals(this.people.getDni(), test);
		assertEquals(this.visitor.getDni(), test);
	}

	@Test
	public void testSetDni() {
		String test = "11.111.111-H";
		this.people.setDni(test);
		this.visitor.setDni(test);
		assertEquals(this.people.getDni(), test);
		assertEquals(this.visitor.getDni(), test);
	}

	@Test
	public void failTestAddres() {
		int max = IConstantes.MAX_ADDRESS + 10;
		String nullString = null;
		// Null specification
		try {
			this.people.setAddress(nullString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_017, e.getMessage());
		}
		try {
			this.visitor.setAddress(nullString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_017, e.getMessage());
		}

		// > max
		try {
			String test = randomString(max);
			this.people.setAddress(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_017, e.getMessage());
		}
		try {
			String test = randomString(max);
			this.visitor.setAddress(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_017, e.getMessage());
		}
	}

	@Test
	public void failTestDNI() {
		// Wrong Letter
		String wrongLetter = "53.991.929-A";
		String badFormating = "53991929G";
		String randomString = randomString(IConstantes.MAX_DNI);
		String overMax = randomString(IConstantes.MAX_DNI + 1);
		String underMin = randomString(IConstantes.MIN_DNI - 1);
		try {
			this.people.setDni(wrongLetter);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}
		try {
			this.visitor.setDni(wrongLetter);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}

		// Bad Formating
		try {
			this.people.setDni(badFormating);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}
		try {
			this.visitor.setDni(badFormating);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}

		// Random String
		try {
			this.people.setDni(randomString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}
		try {
			this.visitor.setDni(randomString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}
		// >max underMin
		try {
			this.people.setDni(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}
		try {
			this.visitor.setDni(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}

		// <min
		try {
			this.people.setDni(underMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}
		try {
			this.visitor.setDni(underMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_012, e.getMessage());
		}
	}

	@Test
	public void failTestEmail() {
		String testInvalid[] = { randomString(IConstantes.MIN_EMAIL - 1), randomString(IConstantes.MAX_EMAIL + 1),
				randomString((IConstantes.MIN_EMAIL + IConstantes.MAX_EMAIL) / 2), "aaa.com",
				randomNumberString(IConstantes.MIN_EMAIL - 1), randomNumberString(IConstantes.MIN_EMAIL), "a@a.",
				"fvas:quez@aaa.com", "felipe@alg(o", "aaaaaaa@a;d.a" };
		for (String string : testInvalid) {
			try {
				this.people.setEmail(string);
				fail("The exception didn't show");
			} catch (FERSGenericException e) {
				assertEquals(IConstantes.ERM_011, e.getMessage());
			}
			try {
				this.visitor.setEmail(string);
				fail("The exception didn't show");
			} catch (FERSGenericException e) {
				assertEquals(IConstantes.ERM_011, e.getMessage());
			}
		}
		// underMin

	}

	@Test
	public void failTestFirstName() {
		String overMax = randomString(IConstantes.MAX_FIRST_NAME + 10);
		String undeMin = randomString(IConstantes.MIN_FIRST_NAME - 1);
		String nullString = null;

		// > max
		try {
			this.visitor.setFirstName(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_015, e.getMessage());
		}
		try {
			this.people.setFirstName(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_015, e.getMessage());
		}
		// < min
		try {
			this.visitor.setFirstName(undeMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_015, e.getMessage());
		}
		try {
			this.people.setFirstName(undeMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_015, e.getMessage());
		}
		// null String
		try {
			this.visitor.setFirstName(nullString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_015, e.getMessage());
		}
		try {
			this.people.setFirstName(nullString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_015, e.getMessage());
		}
	}

	@Test
	public void failTestLastName() {
		String overMax = randomString(IConstantes.MAX_LAST_NAME + 10);
		String undeMin = randomString(IConstantes.MIN_LAST_NAME - 1);
		String nullString = null;

		// > max
		try {
			this.visitor.setLastName(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_016, e.getMessage());
		}
		try {
			this.people.setLastName(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_016, e.getMessage());
		}
		// < min
		try {
			this.visitor.setLastName(undeMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_016, e.getMessage());
		}
		try {
			this.people.setLastName(undeMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_016, e.getMessage());
		}
		// null String
		try {
			this.visitor.setLastName(nullString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_016, e.getMessage());
		}
		try {
			this.people.setLastName(nullString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_016, e.getMessage());
		}
	}

	@Test
	public void failTestPhoneNumber() {
		String randomString = randomString((IConstantes.MIN_PHONE + IConstantes.MAX_PHONE) / 2);
		String overMax = randomNumberString(IConstantes.MAX_PHONE + 10);
		String underMin = randomNumberString(IConstantes.MIN_PHONE - 5);
		// random string of letters in the range
		try {
			this.people.setPhoneNumber(randomString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_010, e.getMessage());
		}
		try {
			this.visitor.setPhoneNumber(randomString);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_010, e.getMessage());
		}

		// > max
		try {
			this.people.setPhoneNumber(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_010, e.getMessage());
		}
		try {
			this.visitor.setPhoneNumber(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_010, e.getMessage());
		}

		// <min
		try {
			this.people.setPhoneNumber(underMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_010, e.getMessage());
		}
		try {
			this.visitor.setPhoneNumber(underMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_010, e.getMessage());
		}
	}

	@Test
	public void failTestPwd() {
		String overMax = randomNumberString(IConstantes.MAX_PWD + 10);
		String underMin = randomNumberString(IConstantes.MIN_PWD - 5);

		// < min
		try {
			this.visitor.setPassword(underMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_014, e.getMessage());
		}

		// > max
		try {
			this.visitor.setPassword(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_014, e.getMessage());
		}
	}

	@Test
	public void failTestUserName() {
		String overMax = randomNumberString(IConstantes.MAX_USERNAME + 10);
		String underMin = randomNumberString(IConstantes.MIN_USERNAME - 5);

		// < min
		try {
			this.visitor.setUserName(underMin);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_013, e.getMessage());
		}

		// > max
		try {
			this.visitor.setUserName(overMax);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_013, e.getMessage());
		}
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
				"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
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
