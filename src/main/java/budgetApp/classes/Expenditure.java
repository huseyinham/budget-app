package budgetApp.classes;

public class Expenditure implements Transaction {

    private double value;
    private String description;

    public Expenditure(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public double getValue() {
        //value *-1 makes it negative
        return value*-1;
    }

    @Override
    public String getDescription(){
        return description;
    }
}
