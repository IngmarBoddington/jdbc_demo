package dao.imp;

import dao.DaoImplTest;
import model.Account;
import org.dbunit.dataset.IDataSet;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountDaoImplTest extends DaoImplTest {

    @Test
    public void testFetchExistingAccount() throws Exception {
        Integer expectedId = 1;
        Integer expectedCustomerId = 1;
        Integer expectedAddressId = 1;
        String expectedUsername = "Username1";
        String expectedPassword = "Password1";
        String expectedCreatedDate = "2014-09-29";

        AccountDaoImpl accountDaoImpl = new AccountDaoImpl(DaoImplTest.connection);
        Account account = accountDaoImpl.fetchAccount(expectedId);

        assertEquals(expectedId, account.getId());
        assertEquals(expectedCustomerId, account.getCustomerId());
        assertEquals(expectedAddressId, account.getAddressId());
        assertEquals(expectedUsername, account.getUsername());
        assertEquals(expectedPassword, account.getPassword());
        assertEquals(expectedCreatedDate, account.getCreatedDate());
    }

    @Test
    public void testUpdateExistingAccount() throws Exception {
        Integer expectedId = 2;
        Integer expectedCustomerId = 3;
        Integer expectedAddressId = 3;
        String expectedUsername = "UsernameX";
        String expectedPassword = "PasswordX";
        String expectedCreatedDate = "2001-01-01";

        AccountDaoImpl accountDaoImpl = new AccountDaoImpl(DaoImplTest.connection);
        Account account = accountDaoImpl.fetchAccount(2);
        account.setCustomerId(expectedCustomerId);
        account.setAddressId(expectedAddressId);
        account.setUsername(expectedUsername);
        account.setPassword(expectedPassword);
        account.setCreatedDate(expectedCreatedDate);
        accountDaoImpl.persistAccount(account);
        Account account2 = accountDaoImpl.fetchAccount(expectedId);

        assertEquals(expectedId, account2.getId());
        assertEquals(expectedCustomerId, account2.getCustomerId());
        assertEquals(expectedAddressId, account2.getAddressId());
        assertEquals(expectedUsername, account2.getUsername());
        assertEquals(expectedPassword, account2.getPassword());
        assertEquals(expectedCreatedDate, account2.getCreatedDate());


    }

    @Test
    public void testInsertAccount() throws Exception {
        Integer expectedId = 4;
        Integer expectedCustomerId = 1;
        Integer expectedAddressId = 1;
        String expectedUsername = "UsernameY";
        String expectedPassword = "PasswordY";
        String expectedCreatedDate = "1999-01-01";

        AccountDaoImpl accountDaoImpl = new AccountDaoImpl(DaoImplTest.connection);
        Account account = new Account(expectedCustomerId, expectedAddressId, expectedUsername, expectedPassword, expectedCreatedDate);
        accountDaoImpl.persistAccount(account);
        Account account2 = accountDaoImpl.fetchAccount(expectedId);

        assertEquals(expectedId, account2.getId());
        assertEquals(expectedCustomerId, account2.getCustomerId());
        assertEquals(expectedAddressId, account2.getAddressId());
        assertEquals(expectedUsername, account2.getUsername());
        assertEquals(expectedPassword, account2.getPassword());
        assertEquals(expectedCreatedDate, account2.getCreatedDate());
    }
}
