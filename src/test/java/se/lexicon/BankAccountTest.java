package se.lexicon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void test_ThatWithDraw_DoesNot_AddNegativeCurrency() {
        //Setup
        BankAccount ba = new BankAccount();
        ba.deposit(100);
        int amount = -100;
        String expected_result = "Withdrawal amount is negative";
        //Execute
        Executable ex = () -> ba.withDraw(amount);
        Exception e = assertThrows(IllegalArgumentException.class, ex);
        //Evaluate
        assertEquals(e.getMessage(), expected_result);
    }

    @Test
    void deposit() {
    }
}