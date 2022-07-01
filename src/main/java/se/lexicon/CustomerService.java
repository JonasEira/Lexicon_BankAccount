package se.lexicon;

import java.util.ArrayList;

public class CustomerService {

    private ArrayList<Customer> customers = new ArrayList<>();


    public CustomerService(){

    }

    public void addCustomer(Customer c) throws IllegalArgumentException {
        if(c.getAccountsSize() < 1){
            throw new IllegalArgumentException("Too few accounts");
        }
        if(findCustomer(c.getEmail()) != null){
            throw new IllegalArgumentException("Not allowed to add duplicate E-mail addresses");
        }
        customers.add(c);
    }

    public Customer getCustomer(int i){
        return customers.get(i);
    }

    public Customer findCustomer(String searchPattern){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getName().startsWith(searchPattern)){
                return customers.get(i);
            }
            if(customers.get(i).getEmail().startsWith(searchPattern)){
                return customers.get(i);
            }
        }
        return null;
    }

    public Customer findCustomer(int id){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == id) {
                return customers.get(i);
            }
        }
        return null;
    }

}
