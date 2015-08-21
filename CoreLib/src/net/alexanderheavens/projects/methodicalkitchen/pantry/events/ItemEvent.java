package net.alexanderheavens.projects.methodicalkitchen.pantry.events;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;

/**
 * Any event to do with an Item.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class ItemEvent {

	private final Item item;

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

	/**
	 * Item of the event.
	 * 
	 * @return Item of the event.
	 */
	public Item getItem() {
		return item;
	}
}
