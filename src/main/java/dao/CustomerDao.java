package dao;

import model.Customer;

public interface CustomerDao {

	Customer fetchCustomer(Integer Id) throws Exception;
	
	Customer persistCustomer(Customer customer) throws Exception;

}