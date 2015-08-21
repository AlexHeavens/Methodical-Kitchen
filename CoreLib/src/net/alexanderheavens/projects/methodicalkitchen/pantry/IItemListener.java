package net.alexanderheavens.projects.methodicalkitchen.pantry;

import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemEvent;

/**
 * Listen for updates to an Item.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public interface IItemListener {

	/**
	 * Called on an event in a subscribed listener.
	 * 
	 * @param event
	 *            the event that has occurred.
	 */
	public void onItemEvent(final ItemEvent event);

	/**
	 * Called to update the listener with the state of a given Item.
	 * 
	 * <p>This is only presently done on adding the listener.</p>
	 * 
	 * @param item
	 */
	public void synchroniseItem(final Item item);
}
