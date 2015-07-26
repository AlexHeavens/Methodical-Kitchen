package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;
import net.alexanderheavens.projects.methodicalkitchen.pantry.PantryItemInstance;

public class PantryItemInstanceTest {

	@Test
	public void testCreateBasicItemInstance() {
		final Pantry testPantry = new Pantry();
		final PantryItemInstance testItemInstance = new PantryItemInstance(testPantry);
		assertEquals(testPantry, testItemInstance.getPantry());
	}

	@Test
	public void testCreateNullPantryItemInstance() {
		try {
			@SuppressWarnings("unused")
			final PantryItemInstance testItemInstance = new PantryItemInstance(null);
			fail("Able to create item instance with null Pantry.");
		} catch (NullPointerException nullPointerException) {
			assertEquals("pantry", nullPointerException.getMessage());
		}
	}

}
