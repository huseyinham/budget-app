package budgetApp.classes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {

    private Account account;

    private Income salary = new Income(1, "paycheck", "salary", 100, 1);
    private Expenditure clothes = new Expenditure(1, "personal", "clothes", 500, 1);
    private Income bonus = new Income(2, "bonuses", "bonus",50, 1);
    private Expenditure food = new Expenditure(2, "food", "food shop",100, 1);

    @Before
    public void setup() {
        account = new Account();
    }

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
        populateAccountWithTwoIncomeTwoExpenditure();
        Assert.assertEquals(mockedTransactionList(), account.getTransactionItems());
    }

    @Test
    public void accountShouldReturnAllIncomeItemsOnly() {
        populateAccountWithTwoIncomeTwoExpenditure();
        Assert.assertEquals(mockedIncomeList(), account.getIncomeItems());
    }

    @Test
    public void accountShouldReturnAllExpenditureItemsOnly() {
        populateAccountWithTwoIncomeTwoExpenditure();
        Assert.assertEquals(mockedExpenditureList(), account.getExpenditureItems());
    }

    @Test
    public void accountTransactionsShouldHaveCorrectId(){
        populateAccountWithTwoIncomeTwoExpenditure();
        Assert.assertEquals(1, account.getTransactionId(0));
        Assert.assertEquals(1, account.getTransactionId(1));
        Assert.assertEquals(2, account.getTransactionId(2));
        Assert.assertEquals(2, account.getTransactionId(3));
    }

    @Test
    public void accountTransactionsShouldHaveCorrectType(){
        populateAccountWithTwoIncomeTwoExpenditure();
        Assert.assertEquals("paycheck", account.getTransactionType(0));
        Assert.assertEquals("personal", account.getTransactionType(1));
        Assert.assertEquals("bonuses", account.getTransactionType(2));
        Assert.assertEquals("food", account.getTransactionType(3));
    }

    @Test
    public void accountTransactionsShouldHaveCorrectDescription(){
        populateAccountWithTwoIncomeTwoExpenditure();
        Assert.assertEquals("salary", account.getTransactionDescription(0));
        Assert.assertEquals("clothes", account.getTransactionDescription(1));
        Assert.assertEquals("bonus", account.getTransactionDescription(2));
        Assert.assertEquals("food shop", account.getTransactionDescription(3));
    }

    @Test
    public void accountTransactionsShouldHaveCorrectAmount(){
        populateAccountWithTwoIncomeTwoExpenditure();
        Assert.assertEquals(100, account.getTransactionAmount(0), 0);
        Assert.assertEquals(-500, account.getTransactionAmount(1), 0);
        Assert.assertEquals(50, account.getTransactionAmount(2), 0);
        Assert.assertEquals(-100, account.getTransactionAmount(3), 0);
    }

    @Test
    public void accountTransactionsShouldHaveCorrectAccountId(){
        populateAccountWithTwoIncomeTwoExpenditure();
        Assert.assertEquals(1, account.getTransactionAccountId(0));
        Assert.assertEquals(1, account.getTransactionAccountId(1));
        Assert.assertEquals(1, account.getTransactionAccountId(2));
        Assert.assertEquals(1, account.getTransactionAccountId(3));
    }

    //Below are refactored methods so we don't have to clog up the above tests
    private void populateAccountWithTwoIncomeTwoExpenditure() {
        account.addTransaction(salary);
        account.addTransaction(clothes);
        account.addTransaction(bonus);
        account.addTransaction(food);
    }
    //This makes an expected Transaction List
    private List<Transaction> mockedTransactionList(){
        List<Transaction> mockedTransactionList = new ArrayList<>();
        mockedTransactionList.add(salary);
        mockedTransactionList.add(clothes);
        mockedTransactionList.add(bonus);
        mockedTransactionList.add(food);
        return mockedTransactionList;
    }

    //This makes an expected Expenditure List
    private List<Transaction> mockedExpenditureList() {
        List<Transaction> mockedExpenditureList = new ArrayList<>();
        mockedExpenditureList.add(clothes);
        mockedExpenditureList.add(food);
        return mockedExpenditureList;
    }

    //This makes an expected Income List
    private List<Transaction> mockedIncomeList(){
        List<Transaction> mockedIncomeList = new ArrayList<>();
        mockedIncomeList.add(salary);
        mockedIncomeList.add(bonus);
        return mockedIncomeList;
    }

}