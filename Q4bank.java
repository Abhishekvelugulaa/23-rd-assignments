package cpm.projectday23;
//4. Banking ApplicationDescription: A program to simulate a simple banking system.Features:Classes: Account, Customer, Transaction.Methods: Deposit, withdraw, transfer funds.Use polymorphism for different account types (savings, current).


abstract class Account {
 private int accNumber;
 private String accHolder;
 protected double accBalance;

 public Account(int accNumber, String accHolder, double accBalance) {
     this.accNumber = accNumber;
     this.accHolder = accHolder;
     this.accBalance = accBalance;
 }

 public abstract void withdraw(double amount);

 public void deposit(double amount) {
     accBalance += amount;
     System.out.println(amount + " deposited. New balance: " + accBalance);
 }

 public void transfer(Account targetAccount, double amount) {
     if (accBalance >= amount) {
         withdraw(amount);
         targetAccount.deposit(amount);
         System.out.println(amount + " transferred to " + targetAccount.accHolder);
     } else {
         System.out.println("Insufficient balance for transfer.");
     }
 }

 @Override
 public String toString() {
     return "Account Number: " + accNumber + ", Holder: " + accHolder + ", Balance: " + accBalance;
 }
}

//Subclass: SavingsAccount
class SavingsAccount extends Account {
 private double minBalance = 500;

 public SavingsAccount(int accNumber, String accHolder, double accBalance) {
     super(accNumber, accHolder, accBalance);
 }

 @Override
 public void withdraw(double amount) {
     if (accBalance - amount >= minBalance) {
         accBalance -= amount;
         System.out.println(amount + " withdrawn. New balance: " + accBalance);
     } else {
         System.out.println("Withdrawal denied! Minimum balance must be maintained.");
     }
 }
}

//Subclass: CurrentAccount
class CurrentAccount extends Account {
 public CurrentAccount(int accNumber, String accHolder, double accBalance) {
     super(accNumber, accHolder, accBalance);
 }

 @Override
 public void withdraw(double amount) {
     if (accBalance >= amount) {
         accBalance -= amount;
         System.out.println(amount + " withdrawn. New balance: " + accBalance);
     } else {
         System.out.println("Insufficient balance!");
     }
 }
}

//Main class
public class Q4bank {
 public static void main(String[] args) {
     Account savingsAcc = new SavingsAccount(201, "Eve", 1500);
     Account currentAcc = new CurrentAccount(202, "David", 2500);

     savingsAcc.deposit(700);
     savingsAcc.withdraw(1300);
     savingsAcc.transfer(currentAcc, 300);

     currentAcc.withdraw(2000);

     System.out.println("\nAccount Details:");
     System.out.println(savingsAcc);
     System.out.println(currentAcc);
 }
}
