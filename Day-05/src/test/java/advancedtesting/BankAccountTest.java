package advancedtesting;

import junittesting.advancedtesting.banktesting.BankAccount;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

    // Setup: Create a bank account with an initial balance of 1000
    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(1000);
    }

    // Test: Deposit money into the account
    @Test
    void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(1500, bankAccount.getBalance(), "Balance should be updated correctly after deposit.");
    }

    // Test: Withdraw money from the account
    @Test
    void testWithdraw() {
        bankAccount.withdraw(200);
        assertEquals(800, bankAccount.getBalance(), "Balance should be updated correctly after withdrawal.");
    }

    // Test: Ensure withdrawal fails when insufficient funds
    @Test
    void testWithdrawInsufficientFunds() {
        boolean result = bankAccount.withdraw(1200);
        assertFalse(result, "Withdrawal should fail when there are insufficient funds.");
        assertEquals(1000, bankAccount.getBalance(), "Balance should remain unchanged if withdrawal fails.");
    }

    // Test: Ensure negative deposits are ignored
    @Test
    void testDepositNegativeAmount() {
        bankAccount.deposit(-100);
        assertEquals(1000, bankAccount.getBalance(), "Balance should not change when depositing a negative amount.");
    }
}

