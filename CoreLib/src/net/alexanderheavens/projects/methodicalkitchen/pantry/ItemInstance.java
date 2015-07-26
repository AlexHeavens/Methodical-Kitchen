package net.alexanderheavens.projects.methodicalkitchen.pantry;

/**
 * An instance of a foodstuff or household item held in a given Pantry.
 *
 * @see Pantry
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class ItemInstance {

	private final Pantry pantry;
	
	/**
	 * Create a new item instance in a given Pantry.
	 * 
	 * @param pantry
	 *            the Pantry to add the item to, must be non-null.
	 */
	public ItemInstance(Pantry pantry) {
		
		if(pantry == null){
			throw new NullPointerException("pantry");
		}
		
		this.pantry = pantry;
		
	}

	/**
	 * The Pantry the item instance was added to.
	 * @return Item Instance's pantry.
	 */
	public Pantry getPantry() {
		return pantry;
	}

}
