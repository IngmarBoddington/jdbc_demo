package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;
    private Account fullAccount;

    @Before
    public void setUpAccount() {
        this.account = new Account(2, 3, "username", "password", "2014-05-01");
    }

    @Before
    public void setUpFullAccount() {
        this.fullAccount = new Account(4, 5, 6, "username", "password", "2014-04-02");
    }

    @After
    public void tearDown() {
        this.account = null;
        this.fullAccount = null;
    }

    @Test
    public void testAccountGetId() {
        Integer expectedValue = null;
        assertEquals(expectedValue, this.account.getId());
    }

    @Test
    public void testFullAccountGetId() {
        Integer expectedValue = 4;
        assertEquals(expectedValue, this.fullAccount.getId());
    }

    @Test
    public void testGetCustomerId() {
        Integer expectedValue = 2;
        assertEquals(expectedValue, this.account.getCustomerId());
    }

    @Test
    public void testGetAddressId() {
        Integer expectedValue = 3;
        assertEquals(expectedValue, this.account.getAddressId());
    }

    @Test
    public void testGetUsername() {
        String expectedValue = "username";
        assertEquals(expectedValue, this.account.getUsername());
    }

    @Test
    public void testGetPassword() {
        String expectedValue = "password";
        assertEquals(expectedValue, this.account.getPassword());
    }

    @Test
    public void testGetCreatedDate() {
        String expectedValue = "2014-05-01";
        assertEquals(expectedValue, this.account.getCreatedDate());
    }

    @Test
    public void testSetValidCustomerId() {
        Integer expectedValue = 6;
        this.account.setCustomerId(expectedValue);
        assertEquals(expectedValue, this.account.getCustomerId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCustomerIdCannotBeNull() {
        this.account.setCustomerId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCustomerIdCannotBeLessThanZero() {
        this.account.setCustomerId(-1);
    }

    @Test
    public void testSetValidAddressId() {
        Integer expectedValue = 7;
        this.account.setAddressId(expectedValue);
        assertEquals(expectedValue, this.account.getAddressId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressIdCannotBeNull() {
        this.account.setAddressId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressIdCannotBeLessThanZero() {
        this.account.setAddressId(-1);
    }

    @Test
    public void testSetValidUsername() {
        String expectedValue = "username";
        this.account.setUsername(expectedValue);
        assertEquals(expectedValue, this.account.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsernameCannotBeNull() {
        this.account.setUsername(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsernameCannotBeEmptyString() {
        this.account.setUsername("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUsernameCannotBeMoreThan50Characters() {
        this.account.setUsername("0123456789012345678901234567890123456789012345678901234567890");
    }

    @Test
    public void testSetValidPassword() {
        String expectedValue = "p455w0rd";
        this.account.setPassword(expectedValue);
        assertEquals(expectedValue, this.account.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPasswordCannotBeNull() {
        this.account.setPassword(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPasswordCannotBeEmptyString() {
        this.account.setPassword("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPasswordCannotBeMoreThan50Characters() {
        this.account.setPassword("0123456789012345678901234567890123456789012345678901234567890");
    }

    @Test
    public void testSetValidCreatedDate() {
        String expectedValue = "2013-01-01";
        this.account.setCreatedDate(expectedValue);
        assertEquals(expectedValue, this.account.getCreatedDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatedDateCannotBeNull() {
        this.account.setCreatedDate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatedDateCannotBeEmptyString() {
        this.account.setCreatedDate("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatedDateMustBeInCorrectFormat() {
        this.account.setCreatedDate("31th March, 2019");
    }
}
