package budgetApp.classes;

public class Income implements Transaction {

    private double value;
    private String description;

    public Income(int value, String description) {
          this.value = value;
          this.description = description;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String getDescription(){
        return description;
    }
}
