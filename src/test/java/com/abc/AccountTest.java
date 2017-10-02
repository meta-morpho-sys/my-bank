/**
 * 
 */
package com.abc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AccountTest {
	private static final double DOUBLE_DELTA = 1e-15;

	@Test
	public void testDeposit() {
		Account checkingAccount = new Account(Account.CHECKING);
		checkingAccount.deposit(1500.00);
		assertEquals(1500.00, checkingAccount.getBalance(), DOUBLE_DELTA);
	}

	@Test
	public void testWithdraw() {
		Account checkingAccount = new Account(Account.CHECKING);
		checkingAccount.deposit(1000.00);
		checkingAccount.withdraw(400.00);
		assertEquals(600.00, checkingAccount.getBalance(), DOUBLE_DELTA);
		
		try {
			checkingAccount.withdraw(601.00);
			fail("No Exception was thrown");
		} catch (Exception e) {
		}
		
	}
	
	
	@Test
	public void testGetAccountType() {
		Account checkingAccount = new Account(Account.CHECKING);
		assertEquals(checkingAccount.getAccountType(), Account.CHECKING);
	}

	@Test
	public void testGetBalance() {
		Account checkingAccount = new Account(Account.CHECKING);
		assertEquals(0.0, checkingAccount.getBalance(), DOUBLE_DELTA);
	}
}
