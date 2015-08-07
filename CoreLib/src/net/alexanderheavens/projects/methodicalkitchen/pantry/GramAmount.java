package net.alexanderheavens.projects.methodicalkitchen.pantry;

public class GramAmount extends Amount {

	public GramAmount(double amount){
		super(amount);
	}

	@Override
	public double amountInKg() {
		return 0.001d;
	}

	@Override
	public String getDisplayName() {
		return "Grams";
	}
	
}
