package model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
	
	private Customer customer;
    private Customer fullCustomer;
	
	@Before
	public void setUpCustomer() {
		this.customer = new Customer("Ingmar", "Boddington", "07756865078", "ingmarboddington@gmail.com");
	}

    @Before
    public void setUpFullCustomer() {
        this.fullCustomer = new Customer(15, "Ingmar", "Boddington", "07756865078", "ingmarboddington@gmail.com");
    }

    @After
    public void tearDown() {
        this.customer = null;
        this.fullCustomer = null;
    }

    @Test
    public void testCustomerGetId() {
        Integer expectedValue = null;
        assertEquals(expectedValue, this.customer.getId());
    }

    @Test
    public void testFullCustomerGetId() {
        Integer expectedValue = 15;
        assertEquals(expectedValue, this.fullCustomer.getId());
    }

    @Test
    public void testGetFirstName() {
        String expectedValue = "Ingmar";
        assertEquals(expectedValue, this.customer.getFirstName());
    }

    @Test
    public void testGetLastname() {
        String expectedValue = "Boddington";
        assertEquals(expectedValue, this.customer.getLastname());
    }

    @Test
    public void testGetTelephone() {
        String expectedValue = "07756865078";
        assertEquals(expectedValue, this.customer.getTelephone());
    }

    @Test
    public void testGetEmail() {
        String expectedValue = "ingmarboddington@gmail.com";
        assertEquals(expectedValue, this.customer.getEmail());
    }

    @Test
    public void testSetValidFirstName() {
        String expectedValue = "John";
        this.customer.setFirstName(expectedValue);
        String actualValue = this.customer.getFirstName();
        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameCannotEqualNull() {
        this.customer.setFirstName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameCannotEqualEmptyString() {
        this.customer.setFirstName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameCannotBeMoreThan50() {
        this.customer.setFirstName("0123456789012345678901234567890123456789012345678901234567890");
    }

    @Test
    public void testSetValidLastname() {
        String expectedValue = "Smith";
        this.customer.setLastname(expectedValue);
        String actualValue = this.customer.getLastname();
        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastnameCannotEqualNull() {
        this.customer.setLastname(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastnameCannotEqualEmptyString() {
        this.customer.setLastname("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastnameCannotBeMoreThan50() {
        this.customer.setLastname("0123456789012345678901234567890123456789012345678901234567890");
    }

    @Test
    public void testSetValidTelephone() {
        String expectedValue = "01428668632";
        this.customer.setTelephone(expectedValue);
        String actualValue = this.customer.getTelephone();
        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTelephoneCannotEqualNull() {
        this.customer.setTelephone(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTelephoneCannotEqualEmptyString() {
        this.customer.setTelephone("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTelephoneCannotBeMoreThan50() {
        this.customer.setTelephone("0123456789012345678901234567890123456789012345678901234567890");
    }

    @Test
    public void testSetValidEmail() {
        String expectedValue = "iboddington@plus.net";
        this.customer.setEmail(expectedValue);
        String actualValue = this.customer.getEmail();
        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmailCannotEqualNull() {
        this.customer.setEmail(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmailCannotEqualEmptyString() {
        this.customer.setEmail("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmailCannotBeMoreThan50() {
        this.customer.setEmail("0123456789012345678901234567890123456789012345678901234567890");
    }
}
