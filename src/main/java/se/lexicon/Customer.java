package se.lexicon;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String email;
    
    private static int idGenerator = 100;
    private int customerId;
    private ArrayList<BankAccount> bankAccounts;

    public Customer(String name, String email) {
        this.setName(name);
        this.setEmail(email);
        this.setCustomerId(idGenerator++);
        bankAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void addBankAccount(BankAccount bankAcc) {
        this.bankAccounts.add(bankAcc);
    }

    public int getAccountsSize() {
        return this.bankAccounts.size();
    }

    public ArrayList<BankAccount> getAllAccounts() {
        return this.bankAccounts;
    }
}
