

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class TestProduct {

	private Connection connection = null;
    private static Random r = new Random();
    private String username = "root";
    private String password = "password";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String driverClass = "com.mysql.jdbc.Driver";
    private String tableSql = "create table MOVIES (ID integer not null, TITLE varchar(255), DIRECTOR varchar(255), SYNOPSIS varchar(255), primary key (ID))";
    private String insertSql = "INSERT INTO MOVIES VALUES (?,?,?,?)";
	
    private void createConnection() {
        try {
            Class.forName(driverClass).newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.err.println("Exception while creating a connection:"
                    + ex.getMessage());
        }
        System.out.println("Connection created successfully");
    }

    private Connection getConnection() {

        if (connection == null) {
            createConnection();
        }

        return connection;
    }
    
    private void createTable(){
    	try {
			Statement stmt = getConnection().createStatement();
			stmt.execute(tableSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void persistMovie() {
    	createTable();
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertSql);

            pst.setInt(1, 1);
            pst.setString(2, "Top Gun");
            pst.setString(3, "Tony Scott");
            pst.setString(4, "Maverick is a hot pilot. When he encounters "
                    + "a pair of MiGs over the Persian Gulf,"
                    + " his wingman is clearly outflown and freaks. "
                    + "On almost no fuel, Maverick is able to talk "
                    + "him back down to the Carrier..");

            pst.execute();
            System.out.println("Movie persisted successfully!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
	public static void main(String[] args) {
		
		TestProduct tp = new TestProduct();
		tp.persistMovie();
	}
	
}
