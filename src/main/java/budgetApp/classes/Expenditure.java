package budgetApp.classes;

public class Expenditure implements Transaction {

    private double value;

    public Expenditure(int value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        //value *-1 makes it negative
        return value;
    }
}
