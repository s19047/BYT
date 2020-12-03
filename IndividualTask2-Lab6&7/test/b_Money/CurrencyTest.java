package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	/** name of EUR currency is EUR **/
	@Test
	public void testGetName(){
		assertEquals("EUR",EUR.getName());
	}

	/** rate of EUR currency is 1.5 **/
	@Test
	public void testGetRate() {
		assertEquals(1.5,EUR.getRate(),0);
	}

	/** set rate of EUR currency to 2.5, check, then set back and check again **/
	@Test
	public void testSetRate() {
		EUR.setRate(2.5);
		assertEquals(2.5,EUR.getRate(),0);


		EUR.setRate(1.5);
		assertEquals(1.5,EUR.getRate(),0);
	}

	/** since the rate of EUR is 1.5, 10 euros should give 15 in global value
	 *  However since we use the integer notation, with last 2 numbers represeting
	 *  decimals, entered amount will be 1000 euros and we expect to get back 1500**/
	@Test
	public void testGlobalValue() {
		assertEquals(1500,(int)EUR.universalValue(1000));
	}

	/** 100 SEK is equal to 10 euros **/
	@Test
	public void testValueInThisCurrency() {
		Money SEK100 = new Money(10000, SEK);
		assertEquals(1000,(int)EUR.valueInThisCurrency(SEK100));
	}

}
