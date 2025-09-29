package com.arfath.elevenlabs;

import java.util.ArrayList;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
        } else {
            transactionHistory.add("Failed deposit attempt: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
        } else {
            transactionHistory.add("Failed withdrawal attempt: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountHolder + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        Account acc = new Account("12345", "Arfath Ahmed", 1000.0);

        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000);
        acc.deposit(300);

        System.out.println("Final Balance: " + acc.getBalance());

        acc.printTransactionHistory();

    }
}
