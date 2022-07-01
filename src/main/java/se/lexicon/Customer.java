package se.lexicon;

public class Customer {
    private String name;
    private String email;
    
    private static int idGenerator = 100;
    private int customerId;

    public Customer(String name, String email) {
        this.setName(name);
        this.setEmail(email);
        this.setCustomerId(idGenerator++);
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
}
