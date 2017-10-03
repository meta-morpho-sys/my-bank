package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CustomerTest {
	@Mock
	Account myMockAccount1;
	Account myMockAccount2;
	Account myMockAccount3;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test //Test customer statement generation
    public void testApp(){
    	
        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(myMockAccount1);
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccounts(){
        Customer oscar = new Customer("Oscar")
                .openAccount(myMockAccount1);
        oscar.openAccount(myMockAccount2);
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Test
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(myMockAccount1);
        oscar.openAccount(myMockAccount2);
        oscar.openAccount(myMockAccount3);
        assertEquals(3, oscar.getNumberOfAccounts());
    }
}
