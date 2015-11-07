package net.alexanderheavens.methodicalkitchen.core.amount;

/**
 * An amount specified in grams.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 *
 */
public class GramAmount extends Amount {

	//// LIFECYCLE
	/**
	 * Create a gram amount.
	 * 
	 * @param amount
	 *            amount in grams.
	 */
	public GramAmount(double amount) {
		super(amount);
	}

	//// GETTERS & SETTERS
	@Override
	public double amountInKg() {
		return 0.001d;
	}

	@Override
	public String getDisplayName() {
		return "Grams";
	}

}
