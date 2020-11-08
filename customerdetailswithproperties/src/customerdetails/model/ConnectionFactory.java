package customerdetails.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Connection connection = null;

	private ConnectionFactory() {
	}

	public static Connection GetConnection() {
		
		InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("db1.properties");
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

		// load the driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

}
