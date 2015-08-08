package net.alexanderheavens.projects.methodicalkitchen.pantry.events;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;
import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;

/**
 * Event for when an Item changes a value in a Pantry.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class ItemChangeEvent extends PantryEvent {

	private final Item oldItem;
	private final Item newItem;

	/**
	 * Create a new ItemChangeEvent recording the old and new state of and Item.
	 * 
	 * @param pantry
	 *            the Pantry that the event occurred within.
	 * @param oldItem
	 *            old state of the Item.
	 * @param newItem
	 *            new state of the Item.
	 */
	public ItemChangeEvent(final Pantry pantry, final Item oldItem, final Item newItem) {
		super(pantry);

		if (oldItem == null) {
			throw new NullPointerException("ItemChangeEvent oldItem");
		}
		if (newItem == null) {
			throw new NullPointerException("ItemChangeEvent newItem");
		}

		this.oldItem = oldItem;
		this.newItem = newItem;
	}

	/**
	 * The previous state of the Item, before the change.
	 * 
	 * @return Old Item state.
	 */
	public Item getOldItem() {
		return oldItem;
	}

	/**
	 * New item state, after the change.
	 * 
	 * @return New state of the Item.
	 */
	public Item getNewItem() {
		return newItem;
	}

}
