package net.alexanderheavens.projects.methodicalkitchen.pantry;

import java.util.Collection;
import java.util.HashSet;

/**
 * A grouping of kitchen items.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 * 
 */
public class Pantry {

	private final HashSet<ItemInstance> itemInstances;

	public Pantry() {
		itemInstances = new HashSet<ItemInstance>();
	}

	/**
	 * Add a given instance of a pantry item to the pantry.
	 * 
	 * @param itemInstance
	 */
	public ItemInstance addItemInstance() {
		final ItemInstance newItemInstance = new ItemInstance(this);
		itemInstances.add(newItemInstance);
		return newItemInstance;
	}

	/**
	 * An iterator over all item instances held in a the Pantry.
	 * 
	 * @return All instances of Items in the Pantry.
	 */
	public Collection<ItemInstance> getItemInstances() {
		return itemInstances;
	}

}
