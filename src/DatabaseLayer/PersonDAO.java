package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Beans.Admin;
import Beans.Person;
import Beans.User;

public class PersonDAO {
	public static boolean createUser(User user){
		try {
			Connection con = DataSource.getInstance().getConnection();
			String insertString = "insert into user values (?,?,?,?,?,?,?,?);";
			PreparedStatement statement = con.prepareStatement(insertString);
			statement.setString(1, user.getID());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getPhoneNumber());
			statement.setString(6, user.getAddress());
			statement.setInt(7, user.getAge());
			statement.setInt(8, 1);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public static Person getUserById(String userID){
		try {
			Connection con = DataSource.getInstance().getConnection();
			Statement statement = con.createStatement();
			String query = "select * from user where userid = " + userID + ";";
			ResultSet result = statement.executeQuery(query);
			String ID = result.getString(1);
			String name = result.getString(2);
			String email = result.getString(3);
			String password = result.getString(4);
			String phone = result.getString(5);
			String address = result.getString(6);
			int age = result.getInt(7);
			int type  = result.getInt(8);
			if(type==1){
				User user = new User(name, ID, age, password, phone, email,address);
				ShoppingCart cart = ShoppingCartDAO.getuserCart(ID);
				user.setShoppingCart(cart);
				ArrayList<Rent> rents = RentDAO.getUserRents(ID);
				return user;
			}
			else{
				Admin admin = new Admin(name, ID, age, password, phone, email,address);
				return admin;
			}
		} catch (SQLException e) {
			return null;
		}
		
	}
}
