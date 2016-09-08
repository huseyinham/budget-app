package budgetApp.classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    /*private Account account;

    @Before
    public void setup() {
        account = new Account(50, 29.99);
    }

    @Test
    public void testGetIncome() {
        Assert.assertEquals(50.0, account.getIncome(), 0);
    }

    @Test
    public void testGetExpenditure() {
        Assert.assertEquals(29.99, account.getExpenditure(), 0);
    }

    @Test
    public void testGetBalance() {
        Assert.assertEquals(20.01, account.getBalance(), 0);
    }*/

    private Account account = new Account();

    @Test
    public void shouldHaveStartBalanceOfZero() {
        Assert.assertEquals(0, account.getBalance(), 0);
    }

    @Test
    public void addingIncomeShouldIncreaseBalance() {
        account.add(new Income(100));
        Assert.assertEquals(100, account.getBalance(), 0);
    }

    @Test
    public void subtractingExpenditureShouldDecreaseBalance() {
        account.subtract(new Expenditure(100));
        Assert.assertEquals(-100, account.getBalance(), 0);
    }

    /*@Test
    public void accountShouldReturnAllIncomeItems() {
        account.add(new Income(100));
        account.add(new Income(200));
        List<Income> incomeItems = account.getIncomeItems();
    }*/
}