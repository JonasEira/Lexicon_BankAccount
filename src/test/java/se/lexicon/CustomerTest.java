package se.lexicon;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @org.junit.jupiter.api.Test
    void test_getName_returnsName() {
        /// Setup test
        String name = "John doe";
        String email = "john.doe@gmail.com";
        Customer c = new Customer(name, email);
        /// Execute test
        String result = c.getName();
        /// Evaluate result
        assertEquals(name, result);
    }

    @org.junit.jupiter.api.Test
    void test_getEmail_returnsEmail() {
        /// Setup test
        String name = "John doe";
        String email = "john.doe@gmail.com";
        Customer c = new Customer(name, email);
        /// Execute test
        String result = c.getEmail();
        /// Evaluate result
        assertEquals(email, result);
    }

    @org.junit.jupiter.api.Test
    void test_FirstIDisOneHundred() {
        /// Setup test
        String name = "John doe";
        String email = "john.doe@gmail.com";
        int firstID = 100;
        Customer c = new Customer(name, email);
        /// Execute test
        /// Evaluate result
        assertEquals(firstID, c.getCustomerId());
    }

}