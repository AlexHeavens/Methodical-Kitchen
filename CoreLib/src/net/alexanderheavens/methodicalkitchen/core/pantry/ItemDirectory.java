package net.alexanderheavens.methodicalkitchen.core.pantry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import net.alexanderheavens.methodicalkitchen.core.pantry.events.ItemChangeEvent;
import net.alexanderheavens.methodicalkitchen.core.pantry.events.ItemEvent;

/**
 * Unique storage and lookup of Items.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 * 
 */
public class ItemDirectory implements IItemListener, Iterable<Item> {

	private final HashMap<String, Item> itemSet;

	/**
	 * Create an empty ItemDirectory.
	 */
	public ItemDirectory() {
		itemSet = new HashMap<String, Item>();
	}

	private void upsertItem(final Item item) {
		itemSet.put(item.getName(), item);
	}

	private void removeItem(final String itemName) {
		itemSet.remove(itemName);
	}

	public void onItemEvent(final ItemEvent event) {
		if (event instanceof ItemChangeEvent) {
			final ItemChangeEvent itemChangeEvent = (ItemChangeEvent) event;
			final Item changeItem = itemChangeEvent.getItem();
			itemSet.remove(itemChangeEvent.getOldName());
			removeItem(itemChangeEvent.getOldName());
			upsertItem(changeItem);
		}
	}

	public int size() {
		return itemSet.size();
	}

	public boolean isEmpty() {
		return itemSet.isEmpty();
	}

	public boolean contains(Object o) {
		return itemSet.containsKey(o);
	}

	public Iterator<Item> iterator() {
		return itemSet.values().iterator();
	}

	public Object[] toArray() {
		return itemSet.values().toArray();
	}

	public <T> T[] toArray(T[] a) {
		return itemSet.values().toArray(a);
	}

	public boolean add(Item e) {
		throw new UnsupportedOperationException("ItemDirectory add");
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException("ItemDirectory remove");
	}

	public boolean containsAll(Collection<?> c) {
		return itemSet.values().containsAll(c);
	}

	public boolean addAll(Collection<? extends Item> c) {
		throw new UnsupportedOperationException("ItemDirectory add");
	}

	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("ItemDirectory remove");
	}

	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("ItemDirectory remove");
	}

	public void clear() {
		throw new UnsupportedOperationException("ItemDirectory remove");
	}

	public void synchroniseItem(final Item item) {
		upsertItem(item);
	}
}
