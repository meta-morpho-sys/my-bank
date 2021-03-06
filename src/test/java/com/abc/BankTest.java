package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void testTransfer() {
    		Bank bank = new Bank();
    		Account checkingAccount = new Account(Account.CHECKING);
    		Account savingsAccount = new Account(Account.SAVINGS);
    		Customer klara = new Customer("Klara");
    		klara.openAccount(checkingAccount);
    		klara.openAccount(savingsAccount);
    		bank.addCustomer(klara);
    		
    		checkingAccount.deposit(1500.0);
    		bank.transfer(300.0, checkingAccount, savingsAccount);
    		
    		assertEquals(1200.0, checkingAccount.getBalance(), DOUBLE_DELTA);	
    		assertEquals(300.0, savingsAccount.getBalance(), DOUBLE_DELTA);
    }

    // TODO Refactor the following tests to reduce dependencies by introducing mocks.
    
    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.CHECKING);
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savingsAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxiSavingsAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }
    
    @Test
    public void firstCustomer() {
	    	Bank bank = new Bank();
	    	Customer bill = new Customer("Bill");
	    	bank.addCustomer(bill);
	    	
	    assertEquals(bill, bank.getFirstCustomer());
    }

    @Test(expected = RuntimeException.class)
    public void firstCustomerYetNoCustomers() {
	    	Bank bank = new Bank();
	    bank.getFirstCustomer();
    }
    
    
}
