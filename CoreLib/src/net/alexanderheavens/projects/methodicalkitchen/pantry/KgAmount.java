package net.alexanderheavens.projects.methodicalkitchen.pantry;

/**
 * Kilogram defined amounts.
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com).
 *
 */
public class KgAmount extends Amount {

	/**
	 * The default quantity for Kilogram amounts.
	 */
	public static final double DFLT_AMOUNT = 1d;

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

	@Override
	public double amountInKg() {
		return 1d;
	}

	@Override
	public String getDisplayName() {
		return "Kilograms";
	}

}
