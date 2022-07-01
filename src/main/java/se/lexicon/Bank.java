package se.lexicon;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;

public class Bank {
    ArrayList<BankAccount> accounts = new ArrayList<>();
    public Bank(){

    }

    public void addAccount(BankAccount acc){
        accounts.add(acc);
    }

    public BankAccount findAccount(int identifier) throws AccountNotFoundException {
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber() == identifier){
                return accounts.get(i);
            }
        }
        throw new AccountNotFoundException("Unable to find account.");
    }

    public void removeAccount(int identifier){
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber() == identifier){
                accounts.remove(i);
                return;
            }
        }
    }

    public class AccountNotFoundException extends Exception {
        public AccountNotFoundException(String s){
            super(s);
        }
    }



}
