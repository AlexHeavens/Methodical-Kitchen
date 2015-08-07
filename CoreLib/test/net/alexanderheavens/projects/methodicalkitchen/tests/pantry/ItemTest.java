package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;

public class ItemTest {

	@Test
	public void testDefaultItem() {
		final Item testItem = new Item();
		assertEquals(Item.DFLT_NAME, testItem.getName());
	}

	@Test
	public void testBasicItem() {
		final String testName = "test_item_49e8wo5";
		final Item testItem = new Item(testName);
		assertEquals(testName, testItem.getName());
	}

	@Test
	public void testNoNameItem() {
		try {
			@SuppressWarnings("unused")
			final Item testItem = new Item("");
			fail("Able to create Item with empty name.");
		} catch (IllegalArgumentException illegalArgumentException) {
			assertEquals("Empty Item name", illegalArgumentException.getMessage());
		}
	}

	@Test
	public void testNullNameItem() {
		try {
			@SuppressWarnings("unused")
			final Item testItem = new Item(null);
			fail("Able to create Item with null name.");
		} catch (NullPointerException nullPointerException) {
			assertEquals("Item name", nullPointerException.getMessage());
		}
	}
}
