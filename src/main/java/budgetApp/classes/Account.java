package budgetApp.classes;

import java.util.ArrayList;
import java.util.List;

public class Account {

    List<Income> incomeItems = new ArrayList<>();
    List<Expenditure> expenditureItems = new ArrayList<>();
    List<Transaction> transactionItems = new ArrayList<>();

    public double getBalance() {
        double balance = 0;
        for (Income income : incomeItems) {
            balance += income.getValue();
        }
        for (Expenditure expenditure : expenditureItems) {
            balance -= expenditure.getValue();
        }
        return balance;
    }

    //Pass transaction into add &  subtract to allow removal of duplicate Lists
    public void add(Income income) {
        incomeItems.add(income);
        transactionItems.add(income);
    }

    public void subtract(Expenditure expenditure) {
        expenditureItems.add(expenditure);
        transactionItems.add(expenditure);
    }

    public Income getIncome(int i) {
        return incomeItems.get(i);
    }

    public List<Income> getIncomeItems() {
        return incomeItems;
    }

    public List<Expenditure> getExpenditureItems() {
        return expenditureItems;
    }

    public List<Transaction> getTransactionItems() {
        return transactionItems;
    }
}
