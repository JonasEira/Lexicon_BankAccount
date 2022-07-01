package se.lexicon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testFindAccount() {
        Bank b = new Bank();
        BankAccount ba = new BankAccount();
        ba.deposit(100);
        b.addAccount(ba);
        int accountNumber = 666;

        Exception ex = assertThrows(Bank.AccountNotFoundException.class, () -> b.findAccount(accountNumber));
        assertEquals("Unable to find account.", ex.getMessage());
    }
}