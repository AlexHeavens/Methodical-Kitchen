package net.alexanderheavens.projects.methodicalkitchen.pantry;

import net.alexanderheavens.projects.methodicalkitchen.pantry.events.PantryEvent;

public interface IPantryListener {

	public void update(PantryEvent event);
	
}
