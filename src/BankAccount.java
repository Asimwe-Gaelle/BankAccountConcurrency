public class BankAccount {
    private String accountNumber;
    private double balance;

    //Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    //Getters and Setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    //deposit method
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }
    //withdraw method
    public synchronized boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance){
            balance = balance - amount;
            return true;
        }
        return false;
    }
}
