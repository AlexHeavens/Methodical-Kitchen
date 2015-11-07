package net.alexanderheavens.methodicalkitchen.core;

import java.util.HashSet;
import java.util.Set;

import net.alexanderheavens.methodicalkitchen.core.pantry.Pantry;

public class Controller {

	private final Set<Pantry> pantrySet;
	
	public Controller(){
		pantrySet = new HashSet<Pantry>();
	}
	
	public Set<Pantry> getPantrySet(){
		return pantrySet;
	}
	
	public Pantry createPantry(){
		final Pantry newPantry = new Pantry();
		pantrySet.add(newPantry);
		return newPantry;
	}
	
}
