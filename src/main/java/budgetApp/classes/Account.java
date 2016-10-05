package budgetApp.classes;

import java.util.ArrayList;
import java.util.List;

public class Account {

    List<Income> incomeItems = new ArrayList<>();
    List<Expenditure> expenditureItems = new ArrayList<>();
    List<Transaction> transactionItems = new ArrayList<>();

    public double getBalance() {
        double balance = 0;
        for (Transaction transaction : transactionItems) {
            balance += transaction.getValue();
        }
        return balance;
    }

    //Pass transaction into add &  subtract to allow removal of duplicate Lists
    public void add(Transaction transaction) {
        transactionItems.add(transaction);
    }

    public void subtract(Transaction transaction) {
        transactionItems.add(transaction);
    }

    public Transaction getIncome(int i) {
        return transactionItems.get(i);
    }

    public Transaction getExpenditure(int i){
        return transactionItems.get(i);
    }

    public List<Transaction> getTransactionItems() {
        return transactionItems;
    }
}
