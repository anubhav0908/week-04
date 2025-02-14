package collections.commonproblems.implementabankingsystem;
import java.util.*;

public class ImplementBankingSystem {
    //creating maps
    private Map<Integer, Double> accounts = new HashMap<>(); // Stores account balances (unordered)
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>(); // Sorts by balance
    private Queue<Integer> withdrawalQueue = new LinkedList<>(); // Processes withdrawals

    public static void main(String[] args) {
        ImplementBankingSystem bank = new ImplementBankingSystem();

        // Adding customer accounts
        bank.addAccount(101, 5000);
        bank.addAccount(102, 10000);
        bank.addAccount(103, 2000);
        bank.addAccount(104, 8000);

        // Depositing money
        bank.deposit(101, 2000);
        bank.deposit(103, 3000);

        // Requesting withdrawals
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(104);

        // Displaying details
        bank.displayAccounts();
        bank.displaySortedAccounts();

        // Processing withdrawal requests
        bank.processWithdrawals();
    }

    // Method to add a new customer account
    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Method to deposit money
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber); // Add new balance
            System.out.println("Deposited ₹" + amount + " to Account " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Method to request a withdrawal (adds to queue)
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
            System.out.println("Withdrawal requested for Account " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processed withdrawal for Account " + accountNumber);
        }
    }

    // Display all accounts (unordered)
    public void displayAccounts() {
        System.out.println("\nAll Accounts (Unordered):");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getValue() + " -> ₹" + entry.getKey());
        }
    }
}

