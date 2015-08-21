package net.alexanderheavens.projects.methodicalkitchen.amount;

/**
 * An amount specified in grams.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class GramAmount extends Amount {

	/**
	 * Create a gram amount.
	 * 
	 * @param amount
	 *            amount in grams.
	 */
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
