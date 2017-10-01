package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.CHECKING);
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }
    
    @Test
    public void transfer() {
    		Bank bank = new Bank();
    		Account checkingAccount = new Account(Account.CHECKING);
    		Account savingsAccount = new Account(Account.SAVINGS);
    		Customer klara = new Customer("Klara");
    		klara.openAccount(checkingAccount);
    		klara.openAccount(savingsAccount);
    		bank.addCustomer(klara);
    		
    		checkingAccount.deposit(1500.0);
//    		bank.transfer(300.0, checkingAccount, savingsAccount);
//    		
//    		assertEquals(300.0, )
//    		TODO complete the test after I have added the "balance"
    		
//    		1. Tell transfer() from which account to which account to transfer money
//    		transfer(amount, fromAccount, toAccount)
//    		2. Tell transfer() the amount 
    		
    		
    		
//    		assert that receiving account equals to (current balance + transfered amount)
    		
    		
    		
    			
    }

}
