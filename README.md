Programming Test
========

This is a dummy application to be used as part of a software development interview; should provide various functions of a retail bank.

abc-bank
--------

#### Steps I have taken to resolve the test:
1. Introduced tests for "Account class", assigned other responsibilities.
2. Added features for:
  * transfer between two accounts of one customer (in Bank class)
  * balance checking (in Account class)
3. Refactored "Customer" class, reduced Customer responsibility and knowledge about account and transactions.
4. Refactored Customer Test class by introducing mocks.
5. Extracted AppTests into a Feature Test file.
6. Extracted currency formatting function into a Utility class.

### Current Features

* A customer can open an account
* A customer can deposit / withdraw funds from an account
* A customer can request a statement that shows transactions and totals for each of their accounts
* Different accounts have interest calculated in different ways
  * **Checking accounts** have a flat rate of 0.1%
  * **Savings accounts** have a rate of 0.1% for the first $1,000 then 0.2%
  * **Maxi-Savings accounts** have a rate of 2% for the first $1,000 then 5% for the next $1,000 then 10%
* A bank manager can get a report showing the list of customers and how many accounts they have
* A bank manager can get a report showing the total interest paid by the bank on all accounts
* A customer can transfer between their accounts

### TO-DO

* Introduce correct money handling - Money or BigDecimal.
* Change **Maxi-Savings accounts** to have an interest rate of 5% assuming no withdrawals in the past 10 days otherwise 0.1%  (started in pseudo-code) 
* Interest rates should accrue and compound daily (incl. weekends), rates above are per-annum
