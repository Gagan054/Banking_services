package bankingPrj;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBankingApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    // Find account by account number
    private static Account findAccount(String accNo) {
        for (Account acc : accounts) {
            if (acc.accountNo.equals(accNo)) {
                return acc;
            }
        }
        return null;
    }

    // Create new account
    private static void createAccount() {
        System.out.print(" Set password for new account: ");
        String pwd = sc.next();
        System.out.print(" Enter initial deposit: ");
        int bal = sc.nextInt();

        Account newAcc = new Account(pwd, bal);
        accounts.add(newAcc);
        System.out.println(" Account created successfully!");
        System.out.println(" Your Account Number is: " + newAcc.accountNo);
    }

    // Deposit into account
    private static void deposit() {
        System.out.print(" Enter account number: ");
        String accNo = sc.next();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print(" Enter amount to deposit: ");
            int amount = sc.nextInt();
            acc.deposit(amount);
        } else {
            System.out.println(" Account not found!");
        }
    }

    // Withdraw from account
    private static void withdraw() {
        System.out.print(" Enter account number: ");
        String accNo = sc.next();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print(" Enter password: ");
            String pwd = sc.next();
            if (acc.password.equals(pwd)) {
                System.out.print(" Enter amount to withdraw: ");
                int amount = sc.nextInt();
                acc.withdraw(amount);
            } else {
                System.out.println(" Incorrect password!");
            }
        } else {
            System.out.println(" Account not found!");
        }
    }

    // Transfer money between accounts
    private static void transfer() {
        System.out.print(" Enter your account number: ");
        String fromAccNo = sc.next();
        Account fromAcc = findAccount(fromAccNo);
        if (fromAcc != null) {
            System.out.print(" Enter password: ");
            String pwd = sc.next();
            if (fromAcc.password.equals(pwd)) {
                System.out.print(" Enter recipient account number: ");
                String toAccNo = sc.next();
                Account toAcc = findAccount(toAccNo);
                if (toAcc != null) {
                    System.out.print(" Enter amount to transfer: ");
                    int amount = sc.nextInt();
                    fromAcc.transfer(toAcc, amount);
                } else {
                    System.out.println(" Recipient account not found!");
                }
            } else {
                System.out.println(" Incorrect password!");
            }
        } else {
            System.out.println(" Your account not found!");
        }
    }

    // Check balance
    private static void checkBalance() {
        System.out.print(" Enter your account number: ");
        String accNo = sc.next();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print(" Enter password: ");
            String pwd = sc.next();
            if (acc.password.equals(pwd)) {
                acc.checkBalance();
            } else {
                System.out.println(" Incorrect password!");
            }
        } else {
            System.out.println(" Account not found!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- 🏦 Simple Banking App ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> transfer();
                case 5 -> checkBalance();
                case 6 -> {
                    System.out.println("Thank you for using our banking app!");
                    return;
                }
                default -> System.out.println(" Invalid choice! Try again.");
            }
        }
    }
}
