package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;
import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;

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
