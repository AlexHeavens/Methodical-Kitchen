package net.alexanderheavens.projects.methodicalkitchen.amount;

/**
 * Kilogram defined amounts.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com).
 *
 */
public class KgAmount extends Amount {

	//// CONSTANTS
	/**
	 * The default quantity for Kilogram amounts.
	 */
	public static final double DFLT_AMOUNT = 1d;

	//// LIFECYCLE
	/**
	 * Create a Kilogram amount with the default amount quantity (DFLT_AMOUNT).
	 */
	public KgAmount() {
		this(DFLT_AMOUNT);
	}

	/**
	 * Create a Kilogram amount with a given amount quantity.
	 * 
	 * @param amount
	 *            the amount of Kilograms represented by this quantity.
	 */
	public KgAmount(double amount) {
		super(amount);
	}

	//// GETTERS & SETTERS
	@Override
	public double amountInKg() {
		return 1d;
	}

	@Override
	public String getDisplayName() {
		return "Kilograms";
	}

}
