package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;
import net.alexanderheavens.projects.methodicalkitchen.pantry.ItemInstance;

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

}
