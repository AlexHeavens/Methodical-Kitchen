package net.alexanderheavens.methodicalkitchen.core.pantry.events;

import net.alexanderheavens.methodicalkitchen.core.pantry.Item;

/**
 * Any event to do with an Item.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class ItemEvent {

	//// FIELDS
	private final Item item;

	//// LIFECYCLE
	/**
	 * Create a new event for a given Item.
	 * 
	 * @param item
	 *            Item where the event has occurred.
	 */
	public ItemEvent(final Item item) {

		if (item == null) {
			throw new NullPointerException("ItemEvent item");
		}

		this.item = item;
	}

	//// GETTERS & SETTERS
	/**
	 * Item of the event.
	 * 
	 * @return Item of the event.
	 */
	public Item getItem() {
		return item;
	}
}
