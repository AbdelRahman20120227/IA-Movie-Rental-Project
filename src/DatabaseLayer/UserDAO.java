package DatabaseLayer;

import java.sql.Connection;

import Beans.User;

public class UserDAO {
	public static boolean createUser(User user){
		Connection con = DBConnection.getConnection();
		String query = "insert into user () values (?,?,?,?)"
	}
}
