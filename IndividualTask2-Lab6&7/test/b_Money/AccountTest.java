package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK;
	Bank SweBank;
	Account testAccount, Alice;
	Money SEK10000 , SEK100;

	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SEK10000 = new Money(1000000, SEK);
		SEK100 = new Money(10000, SEK);
		SweBank = new Bank("SweBank", SEK);

		testAccount = new Account("Hans", SEK, SEK10000);
		Alice = new Account("Alice", SEK, SEK100);

		SweBank.openAccount(Alice);
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		String id = Account.createID();
		testAccount.addTimedPayment(id,20,20,SEK100,SweBank,Alice.getId());
		assertTrue(testAccount.timedPaymentExists(id));

		testAccount.removeTimedPayment(id);
		assertFalse(testAccount.timedPaymentExists(id));
	}

	//Alice's account starts with a 100 SEK, after timed payment it should become 200
	@Test
	public void testTimedPayment(){
		assertEquals(100,Alice.getBalance().getAmount(),0);
		String id = Account.createID();
		testAccount.addTimedPayment(id,1,1,SEK100,SweBank,Alice.getId());
		testAccount.tick();
		assertEquals(200,Alice.getBalance().getAmount(),0);
	}

	//testAccount starts with 10,000 SEK, we will withdraw 100 and test if it becomes 9900
	@Test
	public void testWithdraw() {
		assertEquals(10000,testAccount.getBalance().getAmount(),0);
		testAccount.withdraw(SEK100);
		assertEquals(9900,testAccount.getBalance().getAmount(),0);
	}

	// Alice's account has a balance of 100SEK
	@Test
	public void testGetBalance() {
		assertEquals(SEK100,Alice.getBalance());
	}
}
