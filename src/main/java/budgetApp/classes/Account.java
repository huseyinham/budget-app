package budgetApp.classes;

import java.util.ArrayList;
import java.util.List;

public class Account {

    List<Income> incomeItems = new ArrayList<>();
    List<Expenditure> expenditureItems = new ArrayList<>();

    private double balance = 0;

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

    public void add(Income income) {
        incomeItems.add(income);
        balance += income.getValue();
    }

    public void subtract(Expenditure expenditure) {
        expenditureItems.add(expenditure);
        balance -= expenditure.getValue();
    }
}
