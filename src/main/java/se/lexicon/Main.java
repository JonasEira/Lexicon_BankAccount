package se.lexicon;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe", "john.doe@gmail.com");
        CustomerService custServ = new CustomerService();

        //Trying to add a customer without accounts.
        try {
            custServ.addCustomer(customer);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        BankAccount bankAcc = new BankAccount();
        BankAccount bankAcc2 = new BankAccount();

        //Adding customer to 2 Accounts
        bankAcc.setCustomer(customer);
        bankAcc2.setCustomer(customer);

        //Tieing up the account to the customer and adding it to the service
        customer.addBankAccount(bankAcc);
        custServ.addCustomer(customer);

        Bank bank = new Bank();
        bank.addAccount(bankAcc);
        bank.addAccount(bankAcc2);

        try {
            bank.findAccount(bankAcc.getAccountNumber()).deposit(1000);
            System.out.println("Current balance: " + bank.findAccount(bankAcc.getAccountNumber()).getBalance());
        } catch (Bank.AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            bank.findAccount(bankAcc.getAccountNumber()).withDraw(200);
            System.out.println("Current balance: " + bank.findAccount(bankAcc.getAccountNumber()).getBalance());
        } catch (Bank.AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            bank.findAccount(bankAcc.getAccountNumber()).withDraw(-100); //throws exception
            System.out.println("Current balance: " + bank.findAccount(bankAcc.getAccountNumber()).getBalance());
        } catch (Bank.AccountNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            bank.findAccount(bankAcc.getAccountNumber()).withDraw(900); //throws exception
            System.out.println("Current balance: " + bank.findAccount(bankAcc.getAccountNumber()).getBalance());
        } catch (Bank.AccountNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        ArrayList<BankAccount> accounts = customer.getAllAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + " " + accounts.get(i).getInfo());
        }
        bank.removeAccount(bankAcc.getAccountNumber());
    }
}