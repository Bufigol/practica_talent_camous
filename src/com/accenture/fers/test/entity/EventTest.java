package com.accenture.fers.test.entity;

import static org.junit.Assert.*;

import java.util.function.Consumer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.fers.entity.Event;
import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.IConstantes;

@SuppressWarnings("unused")
public class EventTest {

	Event event;

	@Before
	public void setUp() throws Exception {
		// Creamos un evento correcto
		event = new Event();
		event.setDescription("Esto es un evento");
		event.setDuration("3h");
		event.setEventId(123);
		event.setEventType("safecovid");
		event.setName("Tetro");
		event.setPlace("Madrid");
		event.setSeatsAvailable(34);
		event.setEventId(1);
	}

	/**
	 * Method that executes after every test method
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		event = null;
	}

	@Test
	public void testConstructorEntero() {
		try {
			Event event = new Event(1, "Tetro", "Esto es un evento", "Madrid", "3h", "safecovid", 34);
			assertEquals(this.event, event);
		} catch (FERSGenericException e) {
			fail("A crash occurred during event creation");
		}
	}

	@Test
	public void testEventEvent() {
		Event eventcopy = new Event(event);
		assertEquals(event, eventcopy);
	}

	@Test
	public void testGetName() {
		assertEquals(event.getName(), "Tetro");
	}

	@Test
	public void testSetName() {
		int mean = ((IConstantes.MIN_EVENT_NAME + IConstantes.MAX_EVENT_NAME) / 2);
		String test = randomString(mean);
		event.setName(test);
		assertEquals(event.getName(), test);
	}

	@Test
	public void testGetDescription() {
		String test = "Esto es un evento";
		assertEquals(event.getDescription(), test);
	}

	@Test
	public void testSetDescription() {
		int mean = ((IConstantes.MIN_EVENT_DESCRIPTION + IConstantes.MAX_EVENT_DESCRIPTION) / 2);
		String test = randomString(mean);
		event.setDescription(test);
		assertEquals(event.getDescription(), test);
	}

	@Test
	public void testGetPlace() {
		String test = "Madrid";
		assertEquals(event.getPlace(), test);
	}

	@Test
	public void testSetPlace() {
		int mean = ((IConstantes.MIN_EVENT_PLACE + IConstantes.MAX_EVENT_PLACE) / 2);
		String test = randomString(mean);
		event.setPlace(test);
		assertEquals(event.getPlace(), test);
	}

	@Test
	public void testGetDuration() {
		String test = "3h";
		assertEquals(event.getDuration(), test);
	}

	@Test
	public void testSetDuration() {
		int mean = ((IConstantes.MIN_EVENT_DURATION + IConstantes.MAX_EVENT_DURATION) / 2);
		String test = randomString(mean);
		event.setDuration(test);
		assertEquals(event.getDuration(), test);
	}

	@Test
	public void testGetEventType() {
		String test = "safecovid";
		assertEquals(event.getEventType(), test);
	}

	@Test
	public void testSetEventType() {
		int mean = ((IConstantes.MIN_EVENT_TYPE + IConstantes.MAX_EVENT_TYPE) / 2);
		String test = randomString(mean);
		event.setEventType(test);
		assertEquals(event.getEventType(), test);
	}

	@Test
	public void testGetSeatsAvailable() {
		int test = 34;
		assertEquals(event.getSeatsAvailable(), test);
	}

	@Test
	public void testSetSeatsAvailable() {
		int test = 1000;
		event.setSeatsAvailable(test);
		assertEquals(event.getSeatsAvailable(), test);
	}

	@Test
	public void failMinMaxDescription() {

		try {
			String test = randomString(IConstantes.MIN_EVENT_DESCRIPTION - 1);
			event.setDescription(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_019, e.getMessage());
		}

		try {
			String test = randomString(IConstantes.MAX_EVENT_DESCRIPTION + 10);
			event.setDescription(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_019, e.getMessage());
		}

		try {
			String test = null;
			event.setDescription(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_019, e.getMessage());
		}

	}

	@Test
	public void failMinMaxDuration() {

		try {
			String test = randomString(IConstantes.MIN_EVENT_DURATION - 1);
			event.setDuration(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_021, e.getMessage());
		}

		try {
			String test = randomString(IConstantes.MAX_EVENT_DURATION + 10);
			event.setDuration(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_021, e.getMessage());
		}
		try {
			String test = null;
			event.setDuration(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_021, e.getMessage());
		}
	}

	@Test
	public void failMinMaxEventType() {

		try {
			String test = randomString(IConstantes.MIN_EVENT_TYPE - 1);
			event.setEventType(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_022, e.getMessage());
		}

		try {
			String test = randomString(IConstantes.MAX_EVENT_TYPE + 10);
			event.setEventType(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_022, e.getMessage());
		}

		try {
			String test = null;
			event.setEventType(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_022, e.getMessage());
		}
	}

	@Test
	public void failMinMaxEventName() {

		try {
			String test = randomString(IConstantes.MIN_EVENT_NAME - 1);
			event.setName(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_018, e.getMessage());
		}

		try {
			String test = randomString(IConstantes.MAX_EVENT_NAME + 10);
			event.setName(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_018, e.getMessage());
		}

		try {
			String test = null;
			event.setName(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_018, e.getMessage());
		}
	}

	@Test
	public void failMinMaxEventPlace() {

		try {
			String test = randomString(IConstantes.MIN_EVENT_PLACE - 1);
			event.setPlace(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_020, e.getMessage());
		}

		try {
			String test = randomString(IConstantes.MAX_EVENT_NAME + 10);
			event.setPlace(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_020, e.getMessage());
		}

		try {
			String test = null;
			event.setPlace(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_020, e.getMessage());
		}
	}

	@Test
	public void failMinEventSeatsAvailable() {
		int test = IConstantes.MIN_SEATS_AVAILABLE - 10;
		try {
			event.setSeatsAvailable(test);
			fail("The exception didn't show");
		} catch (FERSGenericException e) {
			assertEquals(IConstantes.ERM_023, e.getMessage());
		}

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
