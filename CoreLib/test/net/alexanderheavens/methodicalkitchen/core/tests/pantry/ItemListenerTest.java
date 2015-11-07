package net.alexanderheavens.methodicalkitchen.core.tests.pantry;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.methodicalkitchen.core.pantry.Item;

public class ItemListenerTest {

	@Test
	public void testAddItemListener() {

		final MockItemListener itemListener = new MockItemListener();
		final Item testItem = new Item();

		assertEquals(0, testItem.getItemListenerCount());
		assertFalse(testItem.hasItemListener(itemListener));

		testItem.addItemListener(itemListener);

	}

}
