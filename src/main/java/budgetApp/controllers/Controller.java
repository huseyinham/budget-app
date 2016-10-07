package budgetApp.controllers;

import budgetApp.classes.Account;
import budgetApp.classes.Income;
import budgetApp.repositories.Repository;

public class Controller {

    private Account account;
    private Repository repository;

   /* public void showStartAccount() {
        account = repository.getAccount();
    }

    public void addIncome() {
        int value = 10; //this should come from web form
        Income income = new Income(value);
        account.addTransaction(income);
        repository.save(account);
    }*/

}
