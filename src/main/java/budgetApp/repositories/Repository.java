package budgetApp.repositories;

import budgetApp.classes.Account;
import budgetApp.classes.Expenditure;
import budgetApp.classes.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    @Autowired
    private DataSource datasource;

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }

    public Expenditure getExpenditureForAccount() {
        return null;
    }

    public Income getIncomeForAccount(int accountId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        return jdbcTemplate.query("SELECT * FROM income WHERE account_id = ?", new Object[]{accountId}, new IncomeExtractor());
    }

//    public void save(Account account) {
//        //Update (?) statement here
//        accounts.put(account.getId(), account);
//    }

    private static class IncomeExtractor implements ResultSetExtractor<Income> {
        @Override
        public Income extractData(ResultSet resultSet) throws SQLException {
            resultSet.next();
            return asIncome(resultSet);
        }

        private static Income asIncome(ResultSet resultSet) throws SQLException{
            int id = resultSet.getInt("id");
            String type = resultSet.getString("type");
            String desc = resultSet.getString("description");
            double amount = resultSet.getDouble("amount");
            int accountId = resultSet.getInt("account_id");
            return new Income(id, type, desc, amount, accountId);
        }
    }
}
