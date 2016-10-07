package budgetApp.classes;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<Transaction> transactionItems = new ArrayList<>();

    public double getBalance() {
        double balance = 0;
        for (Transaction transaction : transactionItems) {
            balance += transaction.getValue();
        }
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactionItems.add(transaction);
    }

    public Transaction getTransaction(int i) {
        return transactionItems.get(i);
    }

    public List<Transaction> getTransactionItems() {
        return transactionItems;
    }

    public List<Transaction> getIncomeItems(){
        List<Transaction> incomeItems = new ArrayList<>();
        for(Transaction transaction : transactionItems){
            if(transaction instanceof Income){
                incomeItems.add(transaction);
            }
        }
        return incomeItems;
    }

    public List<Transaction> getExpenditureItems() {
        List<Transaction> expenditureItems = new ArrayList<>();
        for(Transaction transaction : transactionItems){
            if(transaction instanceof Expenditure){
                expenditureItems.add(transaction);
            }
        }
        return expenditureItems;
    }
}
