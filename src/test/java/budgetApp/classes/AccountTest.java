package budgetApp.classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AccountTest {

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

    @Test
    public void accountShouldReturnAllIncomeItems() {
        Income salary = new Income(100);
        Income bonus = new Income(50);
        account.add(salary);
        account.add(bonus);
        Assert.assertEquals(salary, account.getIncome(0));
        Assert.assertEquals(bonus, account.getIncome(1));
    }

    @Test
    public void accountShouldReturnAllExpenditureItems() {
        Expenditure clothes = new Expenditure(500);
        Expenditure food = new Expenditure(100);
        account.subtract(clothes);
        account.subtract(food);
        // Encapsulation
        List<Expenditure> actualExpenditureItems = account.getExpenditureItems();
        Assert.assertEquals(clothes, actualExpenditureItems.get(0));
        Assert.assertEquals(food, actualExpenditureItems.get(1));
        actualExpenditureItems.add(new Expenditure(3));
    }

    @Test
    public void accountShouldReturnAllIncomesAndExpendituresInOneOrderedList() {
        Income salary = new Income(100);
        Income bonus = new Income(50);
        Expenditure clothes = new Expenditure(500);
        Expenditure food = new Expenditure(100);
        account.add(salary);
        account.subtract(clothes);
        account.add(bonus);
        account.subtract(food);
        // Immutable List http://stackoverflow.com/questions/7713274/java-immutable-collections
        List<Transaction> actualTransactionItems = account.getTransactionItems();
        Assert.assertEquals(salary, actualTransactionItems.get(0));
        Assert.assertEquals(clothes, actualTransactionItems.get(1));
        Assert.assertEquals(bonus, actualTransactionItems.get(2));
        Assert.assertEquals(food, actualTransactionItems.get(3));
    }
}