package dao.imp;

import dao.AddressTypeDao;
import model.AddressType;
import java.sql.*;

public class AddressTypeDaoImpl implements AddressTypeDao {

    Connection conn;

    public AddressTypeDaoImpl(Connection connection) {
        this.conn = connection;
    }

    @Override
    public AddressType fetchAddressType(Integer Id) throws Exception {

        AddressType addressType;

        try {
            String query = "SELECT * FROM AddressType WHERE addressTypeId = ?";
            PreparedStatement statement = this.conn.prepareStatement(query);
            statement.setInt(1, Id.intValue());
            ResultSet myResultSet = statement.executeQuery();
            myResultSet.next();
            addressType = new AddressType(
                myResultSet.getInt("addressTypeId"),
                myResultSet.getString("description")
            );
            statement.close();
        } catch (SQLException e) {
            throw new Exception("Select Failed: " + e.getMessage());
        }
        return addressType;
    }

    @Override
    public AddressType persistAddressType(AddressType addressType) throws Exception {

        Integer newKey = null;

        if (addressType.getId() == null) {
            try {
                String query = "INSERT INTO AddressType (description) VALUES (?);";
                PreparedStatement statement = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, addressType.getDescription());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                newKey = resultSet.getInt(1);
                statement.close();
                if (newKey == null) {
                    throw new Exception("Failed to retrieve next insert id");
                }
                addressType = new AddressType(
                    newKey,
                    addressType.getDescription()
                );
            } catch (SQLException e) {
                throw new Exception("Insert failed: " + e.getMessage());
            }
        } else {
            try {
                String query = "UPDATE AddressType SET description = ? WHERE addressTypeId = ?;";
                PreparedStatement statement = this.conn.prepareStatement(query);
                statement.setString(1, addressType.getDescription());
                statement.setInt(2, addressType.getId());
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                throw new Exception("Update failed" + e.getMessage());
            }
        }

        return addressType;
    }

}
