package net.alexanderheavens.projects.methodicalkitchen.tests.pantry.events;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;
import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemChangeEvent;

public class ItemChangeEventTest {

	@Test
	public void testCreateBasicItemChangeEvent() {
		final String oldName = "Old Item Name";
		final Item item = new Item("New Item name");

		final ItemChangeEvent testItemChangeEvent = new ItemChangeEvent(oldName, item);

		assertEquals(oldName, testItemChangeEvent.getOldName());
		assertNotNull(testItemChangeEvent.getItem());
		assertEquals(item, testItemChangeEvent.getItem());
	}

	@Test
	public void testCreateNullOldNameItemChangeEvent() {
		final Item newTestItem = new Item();

		try {
			@SuppressWarnings("unused")
			final ItemChangeEvent testChangeEvent = new ItemChangeEvent(null, newTestItem);
			fail("Able to create ItemChangeEvent with null oldName");
		} catch (final NullPointerException nullPointerException) {
			assertEquals("ItemChangeEvent oldName", nullPointerException.getMessage());
		}
	}

	@Test
	public void testCreateNullItemChangeEvent() {
		final String oldName = "Old Item name";

		try {
			@SuppressWarnings("unused")
			final ItemChangeEvent testChangeEvent = new ItemChangeEvent(oldName, null);
			fail("Able to create ItemChangeEvent with null item");
		} catch (final NullPointerException nullPointerException) {
			assertEquals("ItemEvent item", nullPointerException.getMessage());
		}
	}

}
