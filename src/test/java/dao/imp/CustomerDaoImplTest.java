package dao.imp;

import dao.DaoImplTest;
import model.Customer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerDaoImplTest extends DaoImplTest {

    @Test
    public void testFetchExistingCustomer() throws Exception {
        Integer expectedId = 1;
        String expectedFirstName = "firstName1";
        String expectedLastname = "lastname1";
        String expectedTelephone = "00000000000";
        String expectedEmail = "email1@email.com";

        CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl(DaoImplTest.connection);
        Customer customer = customerDaoImpl.fetchCustomer(expectedId);

        assertEquals(expectedId, customer.getId());
        assertEquals(expectedFirstName, customer.getFirstName());
        assertEquals(expectedLastname, customer.getLastname());
        assertEquals(expectedTelephone, customer.getTelephone());
        assertEquals(expectedEmail, customer.getEmail());
    }

    @Test
    public void testUpdateExistingCustomer() throws Exception {
        Integer expectedId = 2;
        String expectedFirstName = "firstNameX";
        String expectedLastname = "lastnameX";
        String expectedTelephone = "11111111111";
        String expectedEmail = "another@email.com";

        CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl(DaoImplTest.connection);
        Customer customer = customerDaoImpl.fetchCustomer(expectedId);
        customer.setFirstName(expectedFirstName);
        customer.setLastname(expectedLastname);
        customer.setTelephone(expectedTelephone);
        customer.setEmail(expectedEmail);
        customerDaoImpl.persistCustomer(customer);
        Customer customer2 = customerDaoImpl.fetchCustomer(expectedId);

        assertEquals(expectedId, customer2.getId());
        assertEquals(expectedFirstName, customer2.getFirstName());
        assertEquals(expectedLastname, customer2.getLastname());
        assertEquals(expectedTelephone, customer2.getTelephone());
        assertEquals(expectedEmail, customer2.getEmail());
    }
}
