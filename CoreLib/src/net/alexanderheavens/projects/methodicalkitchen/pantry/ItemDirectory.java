package net.alexanderheavens.projects.methodicalkitchen.pantry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemChangeEvent;
import net.alexanderheavens.projects.methodicalkitchen.pantry.events.ItemEvent;

/**
 * Unique storage and lookup of Items.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class ItemDirectory implements IItemListener, Collection<Item> {

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

	@Override
	public void onItemEvent(final ItemEvent event) {
		if (event instanceof ItemChangeEvent) {
			final ItemChangeEvent itemChangeEvent = (ItemChangeEvent) event;
			final Item changeItem = itemChangeEvent.getItem();
			itemSet.remove(itemChangeEvent.getOldName());
			removeItem(itemChangeEvent.getOldName());
			upsertItem(changeItem);
		}
	}

	@Override
	public int size() {
		return itemSet.size();
	}

	@Override
	public boolean isEmpty() {
		return itemSet.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return itemSet.containsKey(o);
	}

	@Override
	public Iterator<Item> iterator() {
		return itemSet.values().iterator();
	}

	@Override
	public Object[] toArray() {
		return itemSet.values().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return itemSet.values().toArray(a);
	}

	@Override
	public boolean add(Item e) {
		throw new UnsupportedOperationException("ItemDirectory add");
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("ItemDirectory remove");
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return itemSet.values().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Item> c) {
		throw new UnsupportedOperationException("ItemDirectory add");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("ItemDirectory remove");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("ItemDirectory remove");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("ItemDirectory remove");
	}

	@Override
	public void synchroniseItem(final Item item) {
		upsertItem(item);
	}
}
