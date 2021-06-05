package in.micheal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
	private ConnectionUtil() {
		// Default constructor
	}

	private static final String DRIVER_CLASS = System.getenv("spring.datasource.driver-class-name");
	private static final String URL = "jdbc:postgresql://projecttracker.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com/bankapp_db";
	private static final String USERNAME = System.getenv("spring.datasource.username");
	private static final String PASSWORD = System.getenv("spring.datasource.password");

	/**
	 * This method establishes connection between core JAVA and database
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName(DRIVER_CLASS);

		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	/**
	 * This method closes the connection
	 * 
	 * @param connection
	 */
	public static void close(PreparedStatement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method overloading concept to close connection
	 */
	public static void close(ResultSet rs, PreparedStatement statement, Connection connection) {
		try {

			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		getConnection();
	}
}
