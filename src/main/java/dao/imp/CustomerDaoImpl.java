package dao.imp;


import dao.CustomerDao;
import model.Customer;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

	Connection conn;
	
	public CustomerDaoImpl(Connection connection) {
        this.conn = connection;
	}
	
	@Override
	public Customer fetchCustomer(Integer Id) throws Exception {
		
		Customer customer;
		
		try {
			String query = "SELECT * FROM Customer WHERE customerId = ?";
			PreparedStatement statement = this.conn.prepareStatement(query);
			statement.setInt(1, Id.intValue());
			ResultSet myResultSet = statement.executeQuery();
			myResultSet.next();
            customer = new Customer(
                myResultSet.getInt("customerId"),
                myResultSet.getString("firstName"),
                myResultSet.getString("lastname"),
                myResultSet.getString("telephone"),
                myResultSet.getString("email")
            );
			statement.close();
		} catch (SQLException e) {
            throw new Exception("Select Failed: " + e.getMessage());
		}
		return customer;
	}

	@Override
	public Customer persistCustomer(Customer customer) throws Exception {

        Integer newKey = null;

		if (customer.getId() == null) {
            try {
                String query = "INSERT INTO Customer (firstName, lastname, telephone, email) VALUES (?, ?, ?, ?);";
                PreparedStatement statement = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, customer.getFirstName());
                statement.setString(2, customer.getLastname());
                statement.setString(3, customer.getTelephone());
                statement.setString(4, customer.getEmail());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                newKey = resultSet.getInt(1);
                statement.close();
                if (newKey == null) {
                    throw new Exception("Failed to retrieve next insert id");
                }
                customer = new Customer(
                    newKey,
                    customer.getFirstName(),
                    customer.getLastname(),
                    customer.getTelephone(),
                    customer.getEmail()
                );
            } catch (SQLException e) {
                throw new Exception("Insert failed: " + e.getMessage());
            }
        } else {
            try {
                String query = "UPDATE Customer SET firstName = ?, lastname = ?, telephone = ?, email = ? WHERE customerId = ?;";
                PreparedStatement statement = this.conn.prepareStatement(query);
                statement.setString(1, customer.getFirstName());
                statement.setString(2, customer.getLastname());
                statement.setString(3, customer.getTelephone());
                statement.setString(4, customer.getEmail());
                statement.setInt(5, customer.getId());
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                throw new Exception("Update failed" + e.getMessage());
            }
        }

		return customer;
	}
	
}
