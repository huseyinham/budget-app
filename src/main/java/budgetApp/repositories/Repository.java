package budgetApp.repositories;

import budgetApp.classes.Account;
import budgetApp.classes.Expenditure;
import budgetApp.classes.Income;
import budgetApp.classes.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    @Autowired
    private DataSource datasource;

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }

    public Account getAccount(int id) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(getExpenditureForAccount(id));
        transactions.addAll(getIncomeForAccount(id));
        //sort by date at some point - will need to add to db
        return new Account(id, transactions);
    }

    public List<Expenditure> getExpenditureForAccount(int accountId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        return jdbcTemplate.query("SELECT * FROM expenditure WHERE account_id = ?", new Object[]{accountId}, new ExpenditureListExtractor());
    }

    public List<Income> getIncomeForAccount(int accountId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        return jdbcTemplate.query("SELECT * FROM income WHERE account_id = ?", new Object[]{accountId}, new IncomeListExtractor());
    }

//    public void save(Account account) {
//        //Update (?) statement here
//        accounts.put(account.getId(), account);
//    }

    private static class ExpenditureListExtractor implements RowMapper<Expenditure> {
        @Override
        public Expenditure mapRow(ResultSet resultSet, int i) throws SQLException {
            return asExpenditure(resultSet);
        }
    }

    private static class IncomeListExtractor implements RowMapper<Income> {
        @Override
        public Income mapRow(ResultSet resultSet, int i) throws SQLException {
            return asIncome(resultSet);
        }
    }

//    private static class IncomeExtractor implements ResultSetExtractor<Income> {
//        @Override
//        public Income extractData(ResultSet resultSet) throws SQLException {
//            resultSet.next();
//            return asIncome(resultSet);
//        }
//    }

    private static Income asIncome(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String type = resultSet.getString("type");
        String desc = resultSet.getString("description");
        double amount = resultSet.getDouble("amount");
        int accountId = resultSet.getInt("account_id");
        return new Income(id, type, desc, amount, accountId);
    }

    private static Expenditure asExpenditure(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String type = resultSet.getString("type");
        String desc = resultSet.getString("description");
        double amount = resultSet.getDouble("amount");
        int accountId = resultSet.getInt("account_id");
        return new Expenditure(id, type, desc, amount, accountId);
    }
}
