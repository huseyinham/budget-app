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

    //To get Income Items, we loop over the list of Transactions, if it is an instance of Income, we add it to an income items arraylist
    public List<Transaction> getIncomeItems(){
        List<Transaction> incomeItems = new ArrayList<>();
        for(Transaction transaction : transactionItems){
            if(transaction instanceof Income){
                incomeItems.add(transaction);
            }
        }
        return incomeItems;
    }

    //To get Expenditure Items, we loop over the list of Transactions, if it is an instance of Expenditure, we add it to an expenditure items arraylist
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
