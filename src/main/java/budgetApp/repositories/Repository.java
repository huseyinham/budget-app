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
    private Account account = new Account();

// Mocked out for now as no database

    public Account getAccount() {
        //Select statement in here eventually
        return account;
    }

//    public void save(Account account) {
//        //Update (?) statement here
//        accounts.put(account.getId(), account);
//    }

    public Account getAccount(int id) {
        //Get account by id ?
        return accounts.get(id);
    }



}
