package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;
import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;
import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemChangeEvent;

public class ItemChangeEventTest {

	@Test
	public void testCreateBasicItemChangeEvent() {
		final Pantry testPantry = new Pantry();
		final Item oldTestItem = new Item("OldItem");
		final Item newTestItem = new Item("NewItem");

		final ItemChangeEvent testItemChangeEvent = new ItemChangeEvent(testPantry, oldTestItem, newTestItem);

		assertEquals(testPantry, testItemChangeEvent.getPantry());
		assertEquals(oldTestItem, testItemChangeEvent.getOldItem());
		assertEquals(newTestItem, testItemChangeEvent.getNewItem());
	}

	@Test
	public void testCreateNullOldItemChangeEvent() {
		final Pantry testPantry = new Pantry();
		final Item newTestItem = new Item();

		try {
			@SuppressWarnings("unused")
			final ItemChangeEvent testChangeEvent = new ItemChangeEvent(testPantry, null, newTestItem);
			fail("Able to create ItemChangeEvent with null oldItem");
		} catch (final NullPointerException nullPointerException) {
			assertEquals("ItemChangeEvent oldItem", nullPointerException.getMessage());
		}
	}

	@Test
	public void testCreateNullNewItemChangeEvent() {
		final Pantry testPantry = new Pantry();
		final Item oldTestItem = new Item();

		try {
			@SuppressWarnings("unused")
			final ItemChangeEvent testChangeEvent = new ItemChangeEvent(testPantry, oldTestItem, null);
			fail("Able to create ItemChangeEvent with null oldItem");
		} catch (final NullPointerException nullPointerException) {
			assertEquals("ItemChangeEvent newItem", nullPointerException.getMessage());
		}
	}

}
