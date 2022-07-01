package se.lexicon;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe", "john.doe@gmail.com");
        CustomerService custServ = new CustomerService();

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


        bank.removeAccount(bankAcc.getAccountNumber());


    }
}