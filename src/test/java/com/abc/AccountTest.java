/**
 * 
 */
package com.abc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author astarte
 *
 */
public class AccountTest {
	private static final double DOUBLE_DELTA = 1e-15;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.abc.Account#deposit(double)}.
	 */
	@Test
	public void testDeposit() {
		Account checkingAccount = new Account(Account.CHECKING);
		
		checkingAccount.deposit(1500.00);
		assertEquals(1500.00, checkingAccount.getBalance(), DOUBLE_DELTA);
	}

	/**
	 * Test method for {@link com.abc.Account#getAccountType()}.
	 */
	@Test
	public void testGetAccountType() {
		
		Account checkingAccount = new Account(Account.CHECKING);
		
		assertEquals(checkingAccount.getAccountType(), Account.CHECKING);
	}
	
	@Test
	public void testGetBalance() {
		Account checkingAccount = new Account(Account.CHECKING);
		
		checkingAccount.deposit(1000.0);
		
		assertEquals(1000.0, checkingAccount.getBalance(), DOUBLE_DELTA);
		
	}

}
