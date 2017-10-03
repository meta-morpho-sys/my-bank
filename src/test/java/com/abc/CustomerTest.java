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
