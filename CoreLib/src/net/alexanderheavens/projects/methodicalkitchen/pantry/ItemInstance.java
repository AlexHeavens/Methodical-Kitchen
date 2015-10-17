package net.alexanderheavens.projects.methodicalkitchen.pantry;

import net.alexanderheavens.projects.methodicalkitchen.amount.Amount;
import net.alexanderheavens.projects.methodicalkitchen.amount.KgAmount;

/**
 * An instance of a foodstuff or household item held in a given Pantry.
 *
 * @see Pantry
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class ItemInstance {

	//// FIELDS
	private final Pantry pantry;
	private final Amount amount;
	private final Item item;

	//// LIFECYCLE
	/**
	 * Create a default, empty ItemInstance in a given Pantry.
	 * 
	 * @param pantry
	 *            the Pantry to add the item to, must be non-null.
	 */
	public ItemInstance(final Pantry pantry) {
		this(pantry, new Item(), new KgAmount());
	}

	/**
	 * Create a new item instance in a given Pantry.
	 * 
	 * @param pantry
	 *            the Pantry to add the item to, must be non-null.
	 * @param item
	 *            the abstract Item type of the instance.
	 * @param amount
	 *            the amount of the Item stored in this instance.
	 */
	public ItemInstance(final Pantry pantry, final Item item, final Amount amount) {

		if (pantry == null) {
			throw new NullPointerException("ItemInstance pantry");
		}
		if (item == null) {
			throw new NullPointerException("ItemInstance item");
		}
		if (amount == null) {
			throw new NullPointerException("ItemInstance amount");
		}

		this.pantry = pantry;
		this.item = item;
		this.amount = amount;

	}

	//// GETTERS & SETTERS
	/**
	 * The Pantry the item instance was added to.
	 * 
	 * @return Item Instance's pantry.
	 */
	public Pantry getPantry() {
		return pantry;
	}

	/**
	 * The type of Item this is an instance of.
	 * 
	 * @return Item type.
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * The amount of the Item stored in this instance.
	 * 
	 * @return How much of the Item is stored here.
	 */
	public Amount getAmount() {
		return amount;
	}

}
