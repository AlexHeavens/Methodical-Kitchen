package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import static org.junit.Assert.*;

import org.junit.Test;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;
import net.alexanderheavens.projects.methodicalkitchen.pantry.ItemDirectory;
import net.alexanderheavens.projects.methodicalkitchen.pantry.ItemInstance;
import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;

public class ItemDirectoryTest {

	@Test
	public void testCreateBasicDirectory(){
		
		// Create a basic directory and associate it with multiple Pantries.
		final ItemDirectory testDirectory = new ItemDirectory();
		
		// Associate some Pantries with it
		final Pantry testPantryA = new Pantry();
		final Pantry testPantryB = new Pantry();
		
		testPantryA.addItemListener(testDirectory);
		testPantryB.addItemListener(testDirectory);
		assertEquals(0, testDirectory.size());
		
		// Add an item to each Pantry to trigger an update in the directory.
		final ItemInstance itemInstanceA = testPantryA.addItemInstance();
		final Item itemA = itemInstanceA.getItem();
		assertTrue(testDirectory.contains(itemA.getName()));
		assertEquals(1, testDirectory.size());

		final ItemInstance itemInstanceB = testPantryB.addItemInstance();
		assertTrue(testDirectory.contains(itemInstanceB.getItem().getName()));
		assertEquals(1, testDirectory.size());
		
		// Change the name of an Item.
		final String itemANewName = "Item A new name";
		itemA.setName(itemANewName);
		
		assertTrue(testDirectory.contains(itemA.getName()));
		assertEquals(1, testDirectory.size());
	}
	
}