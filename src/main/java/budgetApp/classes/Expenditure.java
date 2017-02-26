package budgetApp.classes;

public class Expenditure implements Transaction {

    private int id;
    private String type;
    private String description;
    private double amount;
    private int accountId;

    public Expenditure(int id, String type, String description, int amount, int accountId) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.accountId = accountId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public double getAmount() {
        //amount *-1 makes it negative
        return amount*-1;
    }

    @Override
    public int getAccountId() {
        return accountId;
    }
}
