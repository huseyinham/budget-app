package budgetApp.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

    private int id;
    private List<Transaction> transactionItems;

    public Account(int id, List<Transaction> transactionItems){
        this.id = id;
        this.transactionItems = transactionItems;
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction transaction : transactionItems) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    //To get Income Items, we loop over the list of Transactions, if it is an instance of Income, we add it to an income items arraylist
    public List<Transaction> getIncomeItems(){
        List<Transaction> incomeItems = transactionItems.stream().filter(transaction -> transaction instanceof Income).collect(Collectors.toList());
        return incomeItems;
    }

    public List<Transaction> getExpenditureItems() {
        List<Transaction> expenditureItems = transactionItems.stream().filter(transaction -> transaction instanceof Expenditure).collect(Collectors.toList());
        return expenditureItems;
    }

    public int getTransactionId(int i) {
        return getTransaction(i).getId();
    }

    public String getTransactionType(int i) {
        return getTransaction(i).getType();
    }

    public String getTransactionDescription(int i) {
        return getTransaction(i).getDescription();
    }

    public double getTransactionAmount(int i) {
        return getTransaction(i).getAmount();
    }

    public int getTransactionAccountId(int i) {
        return getTransaction(i).getAccountId();
    }

    public List<Transaction> getTransactionItems() {
        return transactionItems;
    }

    public Transaction getTransaction(int i) {
        return transactionItems.get(i);
    }

    public void addTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions)
            addTransaction(transaction);
    }

    public void addTransaction(Transaction transaction) {
        transactionItems.add(transaction);
    }
}
