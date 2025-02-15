package junittesting.advancedtesting.banktesting;

public class BankAccount {

    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;  // Insufficient funds or invalid withdrawal amount
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}

