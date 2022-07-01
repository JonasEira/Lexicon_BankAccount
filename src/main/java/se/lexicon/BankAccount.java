package se.lexicon;

public class BankAccount {

    private Customer customer;
    private double balance = 0.0;
    private int accountNumber;
    private static int numberCounter = 1000;

    public BankAccount(){
        this.setAccountNumber(numberCounter++);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void withDraw(int amount) throws IllegalArgumentException {
        if(amount < 0){
            throw new IllegalArgumentException("Withdrawal amount is negative");
        }

        if(this.balance - amount <= 0){
            throw new IllegalArgumentException("Unable to withDraw - too low balance");
        }
        this.balance -= amount;
    }

    public void deposit(int amount) throws IllegalArgumentException {
        if(amount < 0){
            throw new IllegalArgumentException("Withdrawal amount is negative");
        }
        this.balance += amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getInfo() {
        String tmp = "";
        tmp += "Customer name: " + this.customer.getName();
        tmp += " Balance: " + this.balance;
        tmp += " Account number: " + this.accountNumber;
        tmp += " E-mail: " + this.customer.getEmail();
        tmp += " Customer ID: " + this.customer.getCustomerId();
        tmp += " Total accounts: " + (this.customer.getAllAccounts().size() + 1);
        return tmp;
    }
}
