package net.alexanderheavens.projects.methodicalkitchen.amount;

/**
 * Immutable amount.
 * 
 * <p>
 * KgAmounts act as a reference amount type.
 * </p>
 * 
 * @author Alexander Heavens (alexander.heavens@gmail.com)
 * 
 */
public abstract class Amount {

	private final double amount;

	/**
	 * Create an amount with a given numerical quantity.
	 * 
	 * @param amount
	 *            The quantity of the amount (in the metric defined by the
	 *            Amount subclass).
	 */
	public Amount(final double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount <= 0");
		}

		this.amount = amount;
	}

	/**
	 * User-friendly display name for the amount.
	 * 
	 * @return User-facing display name of the amount.
	 */
	public abstract String getDisplayName();

	/**
	 * Produces a new, reference amount in Kilograms.
	 * 
	 * @return New, KgAmount equivalent to this amount.
	 */
	public KgAmount convertToKg() {
		return new KgAmount(amountInKg());
	}

	/**
	 * The quantity of this amount when converted to Kilograms.
	 * 
	 * @return Equivalent amount in Kilograms.
	 */
	public abstract double amountInKg();

	/**
	 * The numerical amount stored in this Amount type.
	 * 
	 * @return Actual amount.
	 */
	public double getAmount() {
		return amount;
	}

}
