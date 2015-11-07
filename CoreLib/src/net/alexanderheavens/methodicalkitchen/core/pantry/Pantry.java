package net.alexanderheavens.methodicalkitchen.core.pantry;

import java.util.Collection;
import java.util.HashSet;

/**
 * A grouping of kitchen items.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 * 
 */
public class Pantry {
	
	//// CONSTANTS
	public static final String DEFAULT_NAME = "My Pantry";

	//// FIELDS
	private final HashSet<ItemInstance> itemInstances;
	private final HashSet<IItemListener> itemListeners;
	private final HashSet<Item> items;
	private String name;

	// // LIFECYCLE
	public Pantry(){
		this(DEFAULT_NAME);
	}
	
	public Pantry(final String name) {
		this.itemInstances = new HashSet<ItemInstance>();
		this.itemListeners = new HashSet<IItemListener>();
		this.items = new HashSet<Item>();
		setName(name);
	}

	// // ITEMS
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

	// // LISTENERS
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

	// // GETTERS & SETTERS
	public void setName(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
