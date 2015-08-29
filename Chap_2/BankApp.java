package Chap_2;

/**
 * Created by user1 on 7/17/15.
 */
public class BankApp {

    private static class BankAccount {
        private double balance;

        public BankAccount(double openingBalance) {
            balance = openingBalance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            balance -= amount;
        }

        public void display() {
            System.out.println("Balance = " + balance);
        }

    }

    public static void main(String[] args) {
        BankAccount bank = new BankAccount(100.00);

        System.out.print("Before transactions: ");
        bank.display();

        bank.deposit(74.35);
        bank.withdraw(20.00);

        System.out.print("After transactions: ");
        bank.display();
    }
}
