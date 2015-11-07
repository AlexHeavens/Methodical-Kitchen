package net.alexanderheavens.methodicalkitchen.core.tests.pantry;

import static org.junit.Assert.*;
import org.junit.Test;

import net.alexanderheavens.methodicalkitchen.core.amount.KgAmount;
import net.alexanderheavens.methodicalkitchen.core.pantry.Item;
import net.alexanderheavens.methodicalkitchen.core.pantry.ItemInstance;

public class ItemInstanceTest {

	@Test
	public void testCreateNullItemInstance() {
		final Item testItem = new Item();
		try {
			@SuppressWarnings("unused")
			final ItemInstance testItemInstance = new ItemInstance(null, testItem, new KgAmount());
			fail("Able to create item instance with null Pantry.");
		} catch (NullPointerException nullPointerException) {
			assertEquals("ItemInstance pantry", nullPointerException.getMessage());
		}
	}

}
