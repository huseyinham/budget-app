package budgetApp.classes;

public class Income implements Transaction {

    private int id;
    private String type;
    private String description;
    private double amount;
    private int accountId;


    public Income(int id, String type, String description, double amount, int accountId) {
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
        return amount;
    }

    @Override
    public int getAccountId() {
        return accountId;
    }
}
