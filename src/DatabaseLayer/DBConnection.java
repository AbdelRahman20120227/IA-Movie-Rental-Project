package DatabaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String url = "";
	static String user = "";
	static String password = "";
	static String driverClass;
	public static Connection getConnection(){
		try {
			Class.forName(driverClass).newInstance();
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			return null;
		}
	}
}
