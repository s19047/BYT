package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	/** 10 euros should return the amount of 10.0 **/
	@Test
	public void testGetAmount() {
		assertTrue(10.0 == EUR10.getAmount());
		assertEquals(10.0,EUR10.getAmount(),0);
	}

	/** 10 euros should return the currency of EUR **/
	@Test
	public void testGetCurrency() {
		assertTrue(EUR == EUR10.getCurrency());
		assertEquals(EUR,EUR10.getCurrency());
	}

	/** 10 euros should be written as 10.00 EUR **/
	@Test
	public void testToString() {
		assertTrue("10.00 EUR".equals(EUR10.toString()));
		assertEquals("10.00 EUR",EUR10.toString());
	}

	/** Since Euros have a global rate of 1.5, the global value of
	 * 10 euros is 15, represented as an integer with the last
	 * two digits denoting decimals that would be 1500 **/
	@Test
	public void testGlobalValue() {
		assertTrue(1500 == EUR10.universalValue());
		assertEquals(1500,(int)EUR10.universalValue());
	}

	/** 10 euros is equal to 100 sek, since sek has a rate of 0.15
	 * , while eur has a rate of 1.5 **/
	@Test
	public void testEqualsMoney() {
		assertTrue(EUR10.equals(SEK100));
		assertEquals(EUR10,SEK100);
	}

	/** Since we already know SEK100 is equal to 10 euros, adding them should give us 20 euros
	 * , or 200 SEK depending on which currency is added to which , also both additions should
	 * logically result in the same value
	 */

	@Test
	public void testAdd() {
		Money m1 = EUR10.add(SEK100);
		Money m2 = SEK100.add(EUR10);

		assertEquals(20.0,m1.getAmount(),0);
		assertEquals(200.0, m2.getAmount(),0);
		assertEquals(m1,m2);
	}

	/** same as above but with subtraction **/
	@Test
	public void testSub() {
		Money m1 = EUR10.sub(SEK100);
		Money m2 = SEK100.sub(EUR10);

		assertEquals(0.0,(double) m1.getAmount(),0);
		assertEquals(0.0,(double) m2.getAmount(),0);
		assertEquals(m1,m2);
	}

	/** 0 EUR is zero **/
	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
	}

	/** SEKn100 has value of negative 100, while SEK100 has 100,
	 * .negate on one should make them equal **/
	@Test
	public void testNegate() {
		assertEquals(SEKn100,SEK100.negate());
	}

	/** 0 if values are equal, -1 if first number
	 * is less than second, +1 if first is more **/
	@Test
	public void testCompareTo() {
		assertEquals(0,EUR10.compareTo(SEK100));
		assertEquals(-1,EUR10.compareTo(SEK200));
		assertEquals(1,SEK200.compareTo(EUR10));
	}
}
