package com.BankAccount;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount user = new BankAccount();
        user.DepositChecking(100);
        user.DepositSavings(500);
        user.WithdrawChecking(100);
        user.WithdrawSavings(200);
        user.Print();
    }
}
