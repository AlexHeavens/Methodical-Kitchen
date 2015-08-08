package net.alexanderheavens.projects.methodicalkitchen.pantry.events;

import net.alexanderheavens.projects.methodicalkitchen.pantry.Pantry;

/**
 * Change in Pantry state.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public abstract class PantryEvent {

	private final Pantry pantry;

	/**
	 * Create a generic event for a given Pantry.
	 * 
	 * @param pantry
	 *            the Pantry the event occurred in.
	 */
	public PantryEvent(final Pantry pantry) {
		if (pantry == null) {
			throw new NullPointerException("PantryEvent pantry");
		}
		this.pantry = pantry;
	}

	/**
	 * The Pantry the event occurred in.
	 * 
	 * @return Pantry of the event.
	 */
	public Pantry getPantry() {
		return pantry;
	}

}
