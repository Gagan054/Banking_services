package bankingPrj;

import java.util.UUID;

public class Account {
    String accountNo;
    String password;
    int balance;

    // Constructor to create a new account
    public Account(String password, int initialDeposit) {
        this.accountNo = UUID.randomUUID().toString().substring(0, 8); // random 8-char account no
        this.password = password;
        this.balance = initialDeposit;
    }

    // Deposit money
    public void deposit(int amount) {
        balance += amount;
        System.out.println("💰 ₹" + amount + " deposited successfully. ✅ New Balance: ₹" + balance);
    }

    // Withdraw money
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("⚠️ Insufficient funds! Current Balance: ₹" + balance);
        } else {
            balance -= amount;
            System.out.println("💸 ₹" + amount + " withdrawn successfully. ✅ Remaining Balance: ₹" + balance);
        }
    }

    // Transfer money
    public void transfer(Account toAcc, int amount) {
        if (amount > balance) {
            System.out.println("⚠️ Insufficient funds for transfer!");
        } else {
            balance -= amount;
            toAcc.balance += amount;
            System.out.println("📤 ₹" + amount + " transferred to Account " + toAcc.accountNo);
            System.out.println("✅ Your new balance: ₹" + balance);
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("📊 Account " + accountNo + " Balance: ₹" + balance);
    }
}
