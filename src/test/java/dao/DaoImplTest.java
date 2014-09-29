package dao;

import connection.Conn;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoImplTest {

    protected static Connection connection;

    @BeforeClass
    public static void createSchema() throws Exception {
        Conn conn = new Conn();
        DaoImplTest.connection = conn.getConnectionUnitTesting();
        FileReader fileReader = new FileReader("src/test/resources/Schema.sql");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine;
        String wholeFile = "";
        while ((currentLine = bufferedReader.readLine()) != null) {
            wholeFile = wholeFile + currentLine;
        }
        PreparedStatement statement = DaoImplTest.connection.prepareStatement(wholeFile);
        statement.executeUpdate();
        statement.close();

        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/Dataset.xml"));

        IDatabaseTester databaseTester = new JdbcDatabaseTester(
                "com.mysql.jdbc.Driver", "jdbc:mysql://localhost/javaTrainingDbUnit", "root", "");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }
}
