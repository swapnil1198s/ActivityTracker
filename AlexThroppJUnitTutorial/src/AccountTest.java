import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AccountTest {
    private Account acc; // An instance of the class under test

    @Before
    public void setUp() throws Exception {
        acc = new Account(0.0);
    }

    @Test
    public void testDeposit() {
        acc.deposit(100.0);
        assertEquals(100.0, acc.getBalance(), 0.0000001);
    }

    @Test
    public void testWithdraw() {
        acc.deposit(100.0);
        assertEquals(100.0, acc.withdraw(100) , 0.0000001);
        assertEquals(0.0, acc.withdraw(100) , 0.0000001);
    }

    @Test
    public void testGetCurrentVal() {
        acc.deposit(100.0);
        assertEquals(100.0, acc.getBalance(), 0.0000001);
        acc.withdraw(100);
        assertEquals(0.0, acc.getBalance(), 0.0000001);

    }
}