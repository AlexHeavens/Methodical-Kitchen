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
	private final HashSet<IItemListener> itemListeners;
	private final HashSet<Item> items;

	public Pantry() {
		itemInstances = new HashSet<ItemInstance>();
		itemListeners = new HashSet<IItemListener>();
		items = new HashSet<Item>();
	}

	/**
	 * Add a given instance of a pantry item to the pantry.
	 * 
	 * @param itemInstance
	 */
	public ItemInstance addItemInstance() {
		final ItemInstance newItemInstance = new ItemInstance(this);
		itemInstances.add(newItemInstance);

		final Item newItem = newItemInstance.getItem();
		items.add(newItem);

		for (final IItemListener listener : itemListeners) {
			newItem.addItemListener(listener);
		}

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

	/**
	 * Add an IItemListener that will receive updates whenever an Item in this
	 * Pantry throws an ItemEvent.
	 * 
	 * <p>
	 * Adding an item listener will automatically subscribe it to all existing
	 * Items in the Pantry.
	 * </p>
	 * 
	 * @param itemListener
	 *            new IItemListener.
	 */
	public void addItemListener(final IItemListener itemListener) {
		itemListeners.add(itemListener);
		for (final Item item : items) {
			item.addItemListener(itemListener);
			itemListener.synchroniseItem(item);
		}
	}

	/**
	 * If a given ItemListener is attached as a listener to this Pantry.
	 * 
	 * @param itemListener
	 * @return itemListener is listening to this Pantry.
	 */
	public boolean isItemListener(final IItemListener itemListener) {
		return itemListeners.contains(itemListener);
	}

}
