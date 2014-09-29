package dao.imp;

import dao.AccountDao;
import model.Account;
import java.sql.*;

public class AccountDaoImpl implements AccountDao {

    Connection conn;

    public AccountDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Account fetchAccount(Integer Id) throws Exception {

        Account account;

        try {
            String query = "SELECT * FROM Account WHERE accountId = ?";
            PreparedStatement statement = this.conn.prepareStatement(query);
            statement.setInt(1, Id.intValue());
            ResultSet myResultSet = statement.executeQuery();
            myResultSet.next();
            account = new Account(
                    myResultSet.getInt("accountId"),
                    myResultSet.getInt("customerId"),
                    myResultSet.getInt("addressId"),
                    myResultSet.getString("username"),
                    myResultSet.getString("password"),
                    myResultSet.getString("createdDate")
            );
            statement.close();
        } catch (SQLException e) {
            throw new Exception("Select Failed: " + e.getMessage());
        }
        return account;
    }

    @Override
    public Account persistAccount(Account account) throws Exception {

        Integer newKey = null;

        if (account.getId() == null) {
            try {
                String query = "INSERT INTO Account (customerId, addressId, username, password, createdDate) VALUES (?, ?, ?, ?, ?);";
                PreparedStatement statement = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, account.getCustomerId());
                statement.setInt(2, account.getAddressId());
                statement.setString(3, account.getUsername());
                statement.setString(4, account.getPassword());
                statement.setString(5, account.getCreatedDate());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                newKey = resultSet.getInt(1);
                statement.close();
                if (newKey == null) {
                    throw new Exception("Failed to retrieve next insert id");
                }
                account = new Account(
                    newKey,
                    account.getCustomerId(),
                    account.getAddressId(),
                    account.getUsername(),
                    account.getPassword(),
                    account.getCreatedDate()
                );
            } catch (SQLException e) {
                throw new Exception("Insert failed: " + e.getMessage());
            }
        } else {
            try {
                String query = "UPDATE Account SET customerId = ?, addressId = ?, username = ?, password = ?, createdDate = ? WHERE accountId = ?;";
                PreparedStatement statement = this.conn.prepareStatement(query);
                statement.setInt(1, account.getCustomerId());
                statement.setInt(2, account.getAddressId());
                statement.setString(3, account.getUsername());
                statement.setString(4, account.getPassword());
                statement.setString(5, account.getCreatedDate());
                statement.setInt(6, account.getId());
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                throw new Exception("Update failed" + e.getMessage());
            }
        }

        return account;
    }
}
