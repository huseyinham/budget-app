package budgetApp.classes;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {

    private Account account = new Account();

    private Income salary = new Income(100);
    private Expenditure clothes = new Expenditure(500);
    private Income bonus = new Income(50);
    private Expenditure food = new Expenditure(100);

    @Test
    public void shouldHaveStartBalanceOfZero() {
        Assert.assertEquals(0, account.getBalance(), 0);
    }

    @Test
    public void addingIncomeShouldIncreaseBalance() {
        account.addTransaction(salary);
        Assert.assertEquals(100, account.getBalance(), 0);
    }

    @Test
    public void addingExpenditureShouldDecreaseBalance() {
        account.addTransaction(clothes);
        Assert.assertEquals(-500, account.getBalance(), 0);
    }

    @Test
    public void accountShouldReturnAllTransactionItems() {
        account.addTransaction(salary);
        account.addTransaction(clothes);
        Assert.assertEquals(salary, account.getTransaction(0));
        Assert.assertEquals(clothes, account.getTransaction(1));
    }

    @Test
    public void accountShouldReturnAllIncomesAndExpendituresInOneOrderedList() {
        account.addTransaction(salary);
        account.addTransaction(clothes);
        account.addTransaction(bonus);
        account.addTransaction(food);
        Assert.assertEquals(mockedTransactionList(), account.getTransactionItems());
    }

    @Test
    public void accountShouldReturnAllIncomeItemsOnly() {
        account.addTransaction(salary);
        account.addTransaction(clothes);
        account.addTransaction(bonus);
        account.addTransaction(food);
        Assert.assertEquals(mockedIncomeList(), account.getIncomeItems());
    }

    @Test
    public void accountShouldReturnAllExpenditureItemsOnly() {
        account.addTransaction(salary);
        account.addTransaction(clothes);
        account.addTransaction(bonus);
        account.addTransaction(food);
        Assert.assertEquals(mockedExpenditureList(), account.getExpenditureItems());
    }

    //Below are refactored methods so we don't have to clog up the above tests
    private List<Transaction> mockedExpenditureList() {
        List<Transaction> mockedExpenditureList = new ArrayList<>();
        mockedExpenditureList.add(clothes);
        mockedExpenditureList.add(food);
        return mockedExpenditureList;
    }

    private List<Transaction> mockedTransactionList(){
        List<Transaction> mockedTransactionList = new ArrayList<>();
        mockedTransactionList.add(salary);
        mockedTransactionList.add(clothes);
        mockedTransactionList.add(bonus);
        mockedTransactionList.add(food);
        return mockedTransactionList;
    }

    private List<Transaction> mockedIncomeList(){
        List<Transaction> mockedIncomeList = new ArrayList<>();
        mockedIncomeList.add(salary);
        mockedIncomeList.add(bonus);
        return mockedIncomeList;
    }

}