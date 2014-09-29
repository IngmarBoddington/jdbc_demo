package dao.imp;

import dao.AddressDao;
import model.Address;
import java.sql.*;

public class AddressDaoImpl implements AddressDao {

    Connection conn;

    public AddressDaoImpl(Connection connection) {
        this.conn = connection;
    }

    @Override
    public Address fetchAddress(Integer Id) throws Exception {

        Address address;

        try {
            String query = "SELECT * FROM Address WHERE addressId = ?";
            PreparedStatement statement = this.conn.prepareStatement(query);
            statement.setInt(1, Id.intValue());
            ResultSet myResultSet = statement.executeQuery();
            myResultSet.next();
            address = new Address(
                myResultSet.getInt("addressId"),
                myResultSet.getInt("customerId"),
                myResultSet.getInt("typeId"),
                myResultSet.getString("firstLine"),
                myResultSet.getString("secondLine"),
                myResultSet.getString("thirdLine"),
                myResultSet.getString("postcode")
            );
            statement.close();
        } catch (SQLException e) {
            throw new Exception("Select Failed: " + e.getMessage());
        }
        return address;
    }

    @Override
    public Address persistAddress(Address address) throws Exception {

        Integer newKey = null;

        if (address.getId() == null) {
            try {
                String query = "INSERT INTO Address (customerId, typeId, firstLine, secondLine, thirdLine, postcode) VALUES (?, ?, ?, ?, ?, ?);";
                PreparedStatement statement = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, address.getCustomerId());
                statement.setInt(2, address.getTypeId());
                statement.setString(3, address.getFirstLine());
                statement.setString(4, address.getSecondLine());
                statement.setString(5, address.getThirdLine());
                statement.setString(6, address.getPostcode());
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                newKey = resultSet.getInt(1);
                statement.close();
                if (newKey == null) {
                    throw new Exception("Failed to retrieve next insert id");
                }
                address = new Address(
                    newKey,
                    address.getCustomerId(),
                    address.getTypeId(),
                    address.getFirstLine(),
                    address.getSecondLine(),
                    address.getThirdLine(),
                    address.getPostcode()
                );
            } catch (SQLException e) {
                throw new Exception("Insert failed: " + e.getMessage());
            }
        } else {
            try {
                String query = "UPDATE Address SET customerId = ?, typeId = ?, firstLine = ?, secondLine = ?, thirdLine = ?, postcode = ? WHERE addressId = ?;";
                PreparedStatement statement = this.conn.prepareStatement(query);
                statement.setInt(1, address.getCustomerId());
                statement.setInt(2, address.getTypeId());
                statement.setString(3, address.getFirstLine());
                statement.setString(4, address.getSecondLine());
                statement.setString(5, address.getThirdLine());
                statement.setString(6, address.getPostcode());
                statement.setInt(7, address.getId());
                statement.executeUpdate();
                statement.close();
            } catch (SQLException e) {
                throw new Exception("Update failed" + e.getMessage());
            }
        }

        return address;
    }

}
