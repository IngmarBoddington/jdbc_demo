package connection;
import java.sql.*;

public class Conn {
	
	static final String DB_URL = "jdbc:mysql://localhost/javaTraining";
    static final String DB_URL_UNITTESTING = "jdbc:mysql://localhost/javaTrainingDbUnit?allowMultiQueries=true";
	static final String USER = "root";
	static final String PASS = "";
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to register MySQL Driver");
		}
		System.out.println("Connecting to database...");
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		return conn;
	}

    public Connection getConnectionUnitTesting() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to register MySQL Driver");
        }
        System.out.println("Connecting to database...");
        Connection conn = DriverManager.getConnection(DB_URL_UNITTESTING,USER,PASS);

        return conn;
    }

}
