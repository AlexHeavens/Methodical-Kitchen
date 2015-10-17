package net.alexanderheavens.projects.methodicalkitchen.tests.pantry;

import java.util.ArrayList;

import net.alexanderheavens.projects.methodicalkitchen.pantry.IItemListener;
import net.alexanderheavens.projects.methodicalkitchen.pantry.Item;
import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemEvent;

/**
 * Tracks ItemEventhes and Items raised as an ItemListener to aid testing.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class MockItemListener implements IItemListener {

	private final ArrayList<ItemEvent> eventList;
	private final ArrayList<Item> synchroniseItemList;

	public MockItemListener() {
		eventList = new ArrayList<ItemEvent>();
		synchroniseItemList = new ArrayList<Item>();
	}

	@Override
	public void onItemEvent(final ItemEvent event) {
		eventList.add(event);
	}

	@Override
	public void synchroniseItem(final Item item) {
		synchroniseItemList.add(item);
	}

	/**
	 * The ItemEvent that occurred for a given call to <code>onItemEvent</code>.
	 * 
	 * @param eventNumber
	 *            at which order was the event was added.
	 * @return The event that was passed to <code>onItemEvent</code> for
	 *         eventNumber order.
	 */
	public ItemEvent getItemEvent(final int eventNumber) {
		return eventList.get(eventNumber);
	}

	/**
	 * The number of ItemEvents that have been recorded.
	 * 
	 * @return The number of ItemEvents that have been recorded.
	 */
	public int getItemEventCount() {
		return eventList.size();
	}

	/**
	 * The Item that was passed for a given call to <code>synchroniseItem</code>
	 * .
	 * 
	 * @param itemNumber
	 *            at which order was the Item was added.
	 * @return The Item that was passed to <code>synchroniseItem</code> for
	 *         itemNumber order.
	 */
	public Item getSynchroniseItem(final int itemNumber) {
		return synchroniseItemList.get(itemNumber);
	}

	/**
	 * The number of synchronised Items have been recorded.
	 * 
	 * @return The number of synchronised Items have been recorded.
	 */
	public int getSynchroniseItemCount() {
		return synchroniseItemList.size();
	}

}
