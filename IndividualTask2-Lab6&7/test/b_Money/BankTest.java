package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	Account TestAccount, Alice;
	Money SEK10000 , SEK100;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SEK10000 = new Money(1000000, SEK);
		SEK100 = new Money(10000, SEK);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);

		Alice = new Account("Alice", SEK, SEK100);
		TestAccount = new Account("Alice", SEK, SEK10000);
		SweBank.openAccount(Alice);
		Nordea.openAccount(TestAccount);
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank",SweBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SweBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException {
		Account myAccount = new Account("Ahmad", SEK, SEK100);
		SweBank.openAccount(myAccount);
		assertTrue(SweBank.hasAccount(myAccount.getId()));

	}

	//Alice starts with 100SEK, we deposit another 100, she should have 200
	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		assertEquals(100,Alice.getBalance().getAmount(),0);
		SweBank.deposit(Alice.getId(),SEK100);
		assertEquals(200,Alice.getBalance().getAmount(),0);
	}
	//testAccount starts with 10,000 SEK, we will withdraw 100 and test if it becomes 9900
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		assertEquals(10000,TestAccount.getBalance().getAmount(),0);
		Nordea.withdraw(TestAccount.getId(),SEK100);
		assertEquals(9900,TestAccount.getBalance().getAmount(),0);
	}

	//TestAccount has a balance of SEK10000
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(SEK10000,Nordea.getBalance(TestAccount.getId()));
	}
	//Alice has a 100 SEK before transfer, After she should have 200
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		assertEquals(100,Alice.getBalance().getAmount(),0);
		Nordea.transfer(TestAccount.getId(),SweBank,Alice.getId(),SEK100);
		assertEquals(200,Alice.getBalance().getAmount(),0);
	}
	//Alice has a 100 SEK before transfer, After she should have 200
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		assertEquals(100,Alice.getBalance().getAmount(),0);
		Nordea.addTimedPayment(TestAccount.getId(),Account.createID(),1,1,SEK100,SweBank,Alice.getId());
		Nordea.tick();
		assertEquals(200,Alice.getBalance().getAmount(),0);
	}
}
