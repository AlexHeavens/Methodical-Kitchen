package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;
import net.alexanderheavens.projects.methodicalkitchen.pantry.PantryItemInstance;

public class PantryTest {

	@Test
	public void testCreateBasicPantry() {
		final int instanceCount = 1000;
		
		Pantry testPantry = new Pantry();
		for(int i = 0; i < instanceCount; i++){
			PantryItemInstance itemInstance = new PantryItemInstance(testPantry);
			assertEquals(testPantry, itemInstance.getPantry());
		}
	}

}
