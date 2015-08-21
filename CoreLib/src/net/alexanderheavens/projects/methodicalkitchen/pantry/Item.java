package net.alexanderheavens.projects.methodicalkitchen.pantry;

import java.util.HashSet;

import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemChangeEvent;
import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemEvent;

/**
 * A kind of item stored within a Pantry.
 * 
 * <p>
 * Items represent abstract objects stored in Pantries (as opposed to
 * ItemInstances, which stored individual quantities of these abstract objects).
 * </p>
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class Item {

	/**
	 * Default name of an Item.
	 */
	public final static String DFLT_NAME = "New Item";

	private String name;
	private boolean inInit = true;
	private final HashSet<IItemListener> listeners;

	/**
	 * Create an Item with the default name, DFLT_NAME.
	 */
	public Item() {
		this(DFLT_NAME);
	}

	/**
	 * Create an Item with a given name.
	 * 
	 * @param name
	 *            the name given to the new Item.
	 */
	public Item(final String name) {

		listeners = new HashSet<IItemListener>();
		setName(name);

		inInit = false;
	}

	public void checkName(final String name) {
		if (name == null) {
			throw new NullPointerException("Item name");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Empty Item name");
		}
	}

	/**
	 * Set the name of the Item
	 * 
	 * @param name
	 *            new name. Cannot be null or empty.
	 */
	public void setName(final String name) {
		final String oldName = getName();

		checkName(name);
		this.name = name;

		if (!inInit) {
			final ItemChangeEvent itemChange = new ItemChangeEvent(oldName, this);
			updateItemListeners(itemChange);
		}
	}

	/**
	 * The name of the Item.
	 * 
	 * @return Name of the Item.
	 */
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof Item) {
			final Item otherItem = (Item) o;
			isEqual = otherItem.getName().equals(getName());
		}
		return isEqual;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Add a new object listening to events in this Pantry.
	 * 
	 * @param itemListener
	 *            new listener.
	 */
	public void addItemListener(final IItemListener itemListener) {
		listeners.add(itemListener);
	}

	private void updateItemListeners(final ItemEvent event) {
		for (final IItemListener listener : listeners) {
			listener.onItemEvent(event);
		}
	}

}
