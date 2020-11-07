package customerdetails.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static Connection conn;
	private ConnectionFactory() {}
	
	public static Connection getConnection() {
		InputStream is = ConnectionFactory.class
							.getClassLoader()
							.getResourceAsStream("C:\\Users\\hp\\eclipse-workspace\\customerdetails\\src\\db1.properties");
		
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		String driver = properties.getProperty("db.driver");
		String url = properties.getProperty("db.url");
		String username = properties.getProperty("db.username");
		String password = properties.getProperty("db.password");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}