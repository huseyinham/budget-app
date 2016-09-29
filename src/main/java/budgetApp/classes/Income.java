package budgetApp.classes;

public class Income implements Transaction {

    private double value;

    public Income(int value) {
          this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
