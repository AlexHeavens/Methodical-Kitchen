package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;
import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;
import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemChangeEvent;
import net.alexanderheavens.projects.methodicalkitchen.pantry.events.PantryEvent;

public class PantryEventTest {

	@Test
	public void testCreateBasicPantryEvent() {
		final Pantry testPantry = new Pantry();
		final Item oldTestItem = new Item("Old Item");
		final Item newTestItem = new Item("New Item");
		final PantryEvent testEvent = new ItemChangeEvent(testPantry, oldTestItem, newTestItem);

		assertEquals(testPantry, testEvent.getPantry());
	}

	@Test
	public void testCreateNullPantryEvent() {
		final Item oldTestItem = new Item();
		final Item newTestItem = new Item();

		try {
			@SuppressWarnings("unused")
			final PantryEvent testEvent = new ItemChangeEvent(null, oldTestItem, newTestItem);
			fail("Able to create PantryEvent with null Pantry.");
		} catch (final NullPointerException nullPointerException) {
			assertEquals("PantryEvent pantry", nullPointerException.getMessage());
		}

	}

}
