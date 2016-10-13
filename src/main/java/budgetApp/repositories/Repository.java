package budgetApp.repositories;

import budgetApp.classes.Account;
import budgetApp.classes.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    private Map<Integer, Account> accounts = new HashMap<>();




// The below was Mike showing me how to mock it out if you didn't have a database ... ours will be full of SQL statements (similar to your pokemon
// one) as we have a database

/*
    private Account account = new Account();

    public Account getAccount() {
        return account;
    }

    public void save(Account account) {
        accounts.put(account.getId(), account);
    }

    public Account getAccount(int id) {
        return accounts.get(id);
    }*/



}
