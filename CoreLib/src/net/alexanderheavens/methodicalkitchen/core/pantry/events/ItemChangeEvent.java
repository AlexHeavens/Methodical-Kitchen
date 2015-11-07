package net.alexanderheavens.methodicalkitchen.core.pantry.events;

import net.alexanderheavens.methodicalkitchen.core.pantry.Item;

/**
 * Event for when an Item changes in some way.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class ItemChangeEvent extends ItemEvent {

	//// FIELDS
	private final String oldName;

	//// LIFECYCLE
	/**
	 * Create a new ItemChangeEvent recording the old and new state of and Item.
	 * 
	 * @param oldName
	 *            the name of the Item prior to modification (it may not have
	 *            changed).
	 * @param item
	 *            item that has changed.
	 */
	public ItemChangeEvent(final String oldName, final Item item) {
		super(item);

		if (oldName == null) {
			throw new NullPointerException("ItemChangeEvent oldName");
		}

		this.oldName = oldName;
	}

	//// GETTERS & SETTERS
	/**
	 * The previous name of the Item, before the change.
	 * 
	 * @return Old Item name.
	 */
	public String getOldName() {
		return oldName;
	}

}
