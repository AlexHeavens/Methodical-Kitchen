package net.alexanderheavens.projects.methodicalkitchen.pantry;

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

	private final String name;

	/**
	 * Create an Item with the default name, DFLT_NAME.
	 * 
	 * @param pantry
	 *            the Pantry that this item was added to.
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

		if (name == null) {
			throw new NullPointerException("Item name");
		}
		if (name.equals("")) {
			throw new IllegalArgumentException("Empty Item name");
		}

		this.name = name;
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
		return o instanceof Item && ((Item) o).name.equals(this.name);
	}

}
