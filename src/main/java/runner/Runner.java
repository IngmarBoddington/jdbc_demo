package runner;

import connection.Conn;
import dao.imp.AddressDaoImpl;
import dao.imp.AddressTypeDaoImpl;
import dao.imp.AccountDaoImpl;
import dao.imp.CustomerDaoImpl;
import model.Account;
import model.Address;
import model.AddressType;
import model.Customer;

import java.sql.*;

public class Runner {
	public static void main(String[] args) {

        try {

            Conn conn = new Conn();
            Connection connection = conn.getConnection();

            //===== ADDRESSTYPE TESTS =====
            AddressTypeDaoImpl addressTypeDaoImpl = new AddressTypeDaoImpl(connection);

            //NEW ADDRESSTYPE - Save
            AddressType addressType = new AddressType("Work Address");
            addressType = addressTypeDaoImpl.persistAddressType(addressType);
            System.out.println(
                "Saved address type with details: "
                + addressType.getDescription()
                + ". New Record ID: "
                + addressType.getId()
            );

            //EXISTING ADDRESSTYPE - Fetch
            Integer Id = addressType.getId();
            addressType = addressTypeDaoImpl.fetchAddressType(Id);
            System.out.println(
                "Fetched address type with ID: "
                + addressType.getId()
                + ". Details: "
                + addressType.getDescription()
            );

            //EXISTING ADDRESSTYPE - Save / Update
            addressType.setDescription("NOT Work Address");
            addressType = addressTypeDaoImpl.persistAddressType(addressType);
            System.out.println(
                "Updated customer with ID: "
                + addressType.getId()
                + ". Details: "
                + addressType.getDescription()
            );

            //===== CUSTOMER TESTS =====
            CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl(connection);

            //NEW CUSTOMER - Save
            Customer customer = new Customer("Bob", "Dilan", "123456", "bob@dilan.com");
            customer = customerDaoImpl.persistCustomer(customer);
            System.out.println(
                "Saved customer with details: "
                + customer.getFirstName()
                + ","
                + customer.getLastname()
                + ","
                + customer.getTelephone()
                + ","
                + customer.getEmail()
                + ". New Record ID: "
                + customer.getId()
            );

            //EXISTING CUSTOMER - Fetch
            Id = customer.getId();
            customer = customerDaoImpl.fetchCustomer(Id);
            System.out.println(
                "Fetched customer with ID: "
                + customer.getId()
                + ". Details: "
                + customer.getFirstName()
                + ","
                + customer.getLastname()
                + ","
                + customer.getTelephone()
                + ","
                + customer.getEmail()
            );

            //EXISTING CUSTOMER - Save / Update
            customer.setEmail("NEW@VALUE.COM");
            customer = customerDaoImpl.persistCustomer(customer);
            System.out.println(
                "Updated customer with ID: "
                    + customer.getId()
                    + ". Details: "
                    + customer.getFirstName()
                    + ","
                    + customer.getLastname()
                    + ","
                    + customer.getTelephone()
                    + ","
                    + customer.getEmail()
            );

            //===== ADDRESS TESTS =====
            // Uses existing AddressType
            AddressDaoImpl addressDaoImpl = new AddressDaoImpl(connection);

            //NEW ADDRESS - Save (using customer after update)
            Address address = new Address(customer.getId(), addressType.getId(), "first line", "second line", "third line", "postcode");

            address = addressDaoImpl.persistAddress(address);
            System.out.println(
                "Saved address with details: "
                + address.getCustomerId()
                + ","
                + address.getTypeId()
                + ","
                + address.getFirstLine()
                + ","
                + address.getSecondLine()
                + ","
                + address.getThirdLine()
                + ","
                + address.getPostcode()
                + ". New Record ID: "
                + address.getId()
            );

            //EXISTING ADDRESS - Fetch
            Id = address.getId();
            address = addressDaoImpl.fetchAddress(Id);
            System.out.println(
                "Fetched address with ID: "
                + address.getId()
                + ". Details: "
                + address.getCustomerId()
                + ","
                + address.getTypeId()
                + ","
                + address.getFirstLine()
                + ","
                + address.getSecondLine()
                + ","
                + address.getThirdLine()
                + ","
                + address.getPostcode()
            );

            //EXISTING ADDRESS - Save / Update
            address.setFirstLine("New first line");
            addressDaoImpl.persistAddress(address);
            System.out.println(
                "Updated address with ID: "
                + address.getId()
                + ". Details: "
                + address.getCustomerId()
                + ","
                + address.getTypeId()
                + ","
                + address.getFirstLine()
                + ","
                + address.getSecondLine()
                + ","
                + address.getThirdLine()
                + ","
                + address.getPostcode()
            );

            //===== ACCOUNT TESTS ====
            // Uses existing customer and address
            AccountDaoImpl accountDaoImpl = new AccountDaoImpl(connection);

            //NEW ACCOUNT - Save (using customer and addresses from above after update)
            Account account = new Account(customer.getId(), address.getId(), "username", "password", "2014-07-23");

            account = accountDaoImpl.persistAccount(account);
            System.out.println(
                "Saved account with details: "
                + account.getCustomerId()
                + ","
                + account.getAddressId()
                + ","
                + account.getUsername()
                + ","
                + account.getPassword()
                + ","
                + account.getCreatedDate()
                + ". New Record ID: "
                + account.getId()
            );

            //EXISTING ACCOUNT - Fetch
            Id = account.getId();
            account = accountDaoImpl.fetchAccount(Id);
            System.out.println(
                "Fetched account with ID: "
                + account.getId()
                + ". Details: "
                + account.getCustomerId()
                + ","
                + account.getAddressId()
                + ","
                + account.getUsername()
                + ","
                + account.getPassword()
                + ","
                + account.getCreatedDate()
            );

            //EXISTING ACCOUNT - Save / Update
            account.setUsername("newUsername");
            accountDaoImpl.persistAccount(account);
            System.out.println(
                "Updated address with ID: "
                + account.getId()
                + ". Details: "
                + account.getCustomerId()
                + ","
                + account.getAddressId()
                + ","
                + account.getUsername()
                + ","
                + account.getPassword()
                + ","
                + account.getCreatedDate()
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
}
