package customerdetails.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionFactory {
	private static Connection connection=null;
	private ConnectionFactory()
	{
		
	}
	public static Connection GetConnection()
	{
		
		String dbUrl = "jdbc:mysql://localhost:3306/krishna";
		String user = "client";		
		String pass = "client";
		
			try {
				connection = DriverManager.getConnection(dbUrl, user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
	}

}
