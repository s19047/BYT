package b_Money;

import java.math.BigDecimal;

public class Currency {
	private String name;
	private Double rate;

	/**
	 * New Currency
	 * The rate argument of each currency indicates that Currency's "universal" exchange rate.
	 * Imagine that we define the rate of each currency in relation to some universal currency.
	 * This means that the rate of each currency defines its value compared to this universal currency.
	 *
	 * @param name The name of this Currency
	 * @param rate The exchange rate of this Currency
	 */
	Currency (String name, Double rate) {
		this.name = name;
		this.rate = rate;
	}

	/** Convert an amount of this Currency to its value in the general "universal currency"
	 * (As mentioned in the documentation of the Currency constructor)
	 *
	 * @param amount An amount of cash of this currency.
	 * @return The value of amount in the "universal currency"
	 */
	public Integer universalValue(Integer amount) {
		return (int)(amount*rate);
	}

	/** converts double to an integer value having the last two digits as the decimal part **/

	public static Integer toInt(Double d){
		String doubleAsString = String.valueOf(d);
		int indexOfDecimal = doubleAsString.indexOf(".");
		//in case double is something like 2000.0
		if(doubleAsString.length() - indexOfDecimal == 2)
			doubleAsString += "0";
		String integerPart = doubleAsString.substring(0, indexOfDecimal);
		String decimalPart = doubleAsString.substring(indexOfDecimal+1,indexOfDecimal+3);
		return Integer.parseInt(integerPart+decimalPart);
	}


	/** Get the name of this Currency.
	 * @return name of Currency
	 */
	public String getName() {
		return name;
	}

	/** Get the rate of this Currency.
	 *
	 * @return rate of this Currency
	 */
	public Double getRate() {
		return rate;
	}

	/** Set the rate of this currency.
	 *
	 * @param rate New rate for this Currency
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}

	/** Convert an amount from another Currency to an amount in this Currency
	 *
	 * @param money the money in the other currency
	 */
	public Integer valueInThisCurrency(Money money) {
		return toInt(money.getAmount()*(money.getCurrency().rate/this.rate));
	}
}
