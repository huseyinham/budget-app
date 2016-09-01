package budgetApp.classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    private Account account;

    @Before
    public void setup() {
        account = new Account(50, 29.99);
    }

    @Test
    public void testGetBalance() {
        Assert.assertEquals(20.01, account.getBalance(), 0);
    }

    @Test
    public void testGetIncome() {
        Assert.assertEquals(50.0, account.getIncome(), 0);
    }

    @Test
    public void testGetExpenditure() {
        Assert.assertEquals(29.99, account.getExpenditure(), 0);
    }
}
