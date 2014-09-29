package dao;

import model.Account;

public interface AccountDao {

    Account fetchAccount(Integer Id) throws Exception;

    Account persistAccount(Account account) throws Exception;
}
