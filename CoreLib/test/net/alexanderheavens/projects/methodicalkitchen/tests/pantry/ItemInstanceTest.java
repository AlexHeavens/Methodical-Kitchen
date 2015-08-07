package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;
import org.junit.Test;
import net.alexanderheavens.projects.methodicalkitchen.pantry.ItemInstance;

public class ItemInstanceTest {

	@Test
	public void testCreateNullItemInstance() {
		try {
			@SuppressWarnings("unused")
			final ItemInstance testItemInstance = new ItemInstance(null);
			fail("Able to create item instance with null Pantry.");
		} catch (NullPointerException nullPointerException) {
			assertEquals("pantry", nullPointerException.getMessage());
		}
	}

}
