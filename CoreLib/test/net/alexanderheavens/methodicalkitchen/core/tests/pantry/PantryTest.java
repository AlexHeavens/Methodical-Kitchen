package net.alexanderheavens.methodicalkitchen.core.tests.pantry;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import net.alexanderheavens.methodicalkitchen.core.pantry.Item;
import net.alexanderheavens.methodicalkitchen.core.pantry.ItemInstance;
import net.alexanderheavens.methodicalkitchen.core.pantry.Pantry;

public class PantryTest {

	@Test
	public void testCreateBasicPantry() {
		final int instanceCount = 1000;
		final HashSet<ItemInstance> testItemInstanceSet = new HashSet<ItemInstance>(instanceCount);

		final Pantry testPantry = new Pantry();
		for (int i = 0; i < instanceCount; i++) {
			testItemInstanceSet.add(testPantry.addItemInstance());
		}

		final HashSet<ItemInstance> instancesPresent = new HashSet<ItemInstance>(instanceCount);
		for (ItemInstance itemInstance : testPantry.getItemInstances()) {
			assertEquals(testPantry, itemInstance.getPantry());
			assertFalse(instancesPresent.contains(itemInstance));
			instancesPresent.add(itemInstance);
			assertTrue(testItemInstanceSet.contains(itemInstance));
		}
		assertEquals(testItemInstanceSet.size(), instancesPresent.size());
	}

	@Test
	public void testAddItemListeners() {

		final Pantry testPantry = new Pantry();

		final MockItemListener testItemListenerA = new MockItemListener();
		final MockItemListener testItemListenerB = new MockItemListener();

		// Check that the default state of the Pantry is correct.
		assertFalse(testPantry.isItemListener(testItemListenerA));
		assertFalse(testPantry.isItemListener(testItemListenerB));

		// Add and check that ItemListeners are added appropriately.
		testPantry.addItemListener(testItemListenerA);

		assertTrue(testPantry.isItemListener(testItemListenerA));
		assertFalse(testPantry.isItemListener(testItemListenerB));

		testPantry.addItemListener(testItemListenerB);

		assertTrue(testPantry.isItemListener(testItemListenerA));
		assertTrue(testPantry.isItemListener(testItemListenerB));

		assertEquals(0, testItemListenerA.getItemEventCount());
		assertEquals(0, testItemListenerB.getItemEventCount());
		assertEquals(0, testItemListenerA.getSynchroniseItemCount());
		assertEquals(0, testItemListenerB.getSynchroniseItemCount());

		// Check that item synchronisation is working.

		testPantry.addItemInstance();

		assertEquals(0, testItemListenerA.getItemEventCount());
		assertEquals(0, testItemListenerB.getItemEventCount());
		assertEquals(1, testItemListenerA.getSynchroniseItemCount());
		assertEquals(1, testItemListenerB.getSynchroniseItemCount());

		final Item itemA = testItemListenerA.getSynchroniseItem(0);

		assertNotNull(itemA);
		assertEquals(Item.DFLT_NAME, itemA.getName());

		final Item itemA2 = testItemListenerB.getSynchroniseItem(0);
		assertTrue(itemA == itemA2);

	}

}
