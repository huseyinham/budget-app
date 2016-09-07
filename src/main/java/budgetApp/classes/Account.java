package budgetApp.classes;

public class Account {

    private double income;
    private double expenditure;

    public Account (double income, double expenditure){
        this.income = income;
        this.expenditure = expenditure;
    }

    public double getIncome() {
        return income;
    }

    public double getExpenditure() {
        return expenditure;
    }

    public double getBalance() {
        return income - expenditure;
    }
}
