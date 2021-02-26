package com.BankAccount;
import java.util.Random;

public class BankAccount {
    private String AccountNumber;
    private double CheckingBalance;
    private double SavingsBalance;

    public static int NumAccount = 0;
    public static double totalAmount =0;

    private static String getAccountNumber(){
        String AccountNum = "";
        Random num = new Random();
        for (int i=0; i<10; i++){
            AccountNum += num.nextInt(10);}
        return AccountNum;
    }

    public BankAccount(){
        this.SavingsBalance = 0;
        this.CheckingBalance = 0;
        setAccountNumber(getAccountNumber());
        NumAccount += 1;

    }
    public double getCheckingBalance(){
        return this.CheckingBalance;
    }

    public double getSavingsBalance() {
        return this.SavingsBalance;
    }

    public static int getNumAccount() {
        return NumAccount;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setCheckingBalance(double checkingBalance) {
        CheckingBalance = checkingBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        SavingsBalance = savingsBalance;
    }

    public void DepositChecking(double amount){
        this.CheckingBalance += amount;
        totalAmount += amount;
    }
    public void DepositSavings(double amount){
        this.SavingsBalance += amount;
        totalAmount += amount;
    }
    public void WithdrawChecking(double amount){
        if (this.CheckingBalance - amount >= 0){
            this.CheckingBalance -= amount;
            totalAmount -= amount;
        }
        else{
            System.out.print("not enough balance, get a job");
        }
    }
    public void WithdrawSavings(double amount){
        if (this.SavingsBalance - amount >= 0) {
            this.SavingsBalance -= amount;
            totalAmount -= amount;
        }
        else{
            System.out.print("not enough balance, get a job");
        }
    }
    public void Print(){
        System.out.println(getCheckingBalance());
        System.out.println(getSavingsBalance());
    }

}
