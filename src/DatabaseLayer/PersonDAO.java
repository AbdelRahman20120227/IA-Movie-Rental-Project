package DatabaseLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Beans.Admin;
import Beans.Movie;
import Beans.Person;
import Beans.Rent;
import Beans.ShoppingCart;
import Beans.ShoppingCart.Pair;
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
	public static boolean createAdmin(Admin admin){
		try {
			Connection con = DataSource.getInstance().getConnection();
			String insertString = "insert into user values (?,?,?,?,?,?,?,?);";
			PreparedStatement statement = con.prepareStatement(insertString);
			statement.setString(1, admin.getID());
			statement.setString(2, admin.getName());
			statement.setString(3, admin.getEmail());
			statement.setString(4, admin.getPassword());
			statement.setString(5, admin.getPhoneNumber());
			statement.setString(6, admin.getAddress());
			statement.setInt(7, admin.getAge());
			statement.setInt(8, 2);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public static ArrayList<User> getAllUsers(){
		Connection con;
		try {
			con = DataSource.getInstance().getConnection();
			Statement statement = con.createStatement();
			String query = "select * from user where usertype = 1;";
			ResultSet result = statement.executeQuery(query);
			ArrayList<User> users = new ArrayList<User>();
			while(result.next()){
				String ID = result.getString(1);
				String name = result.getString(2);
				String email = result.getString(3);
				String password = result.getString(4);
				String phone = result.getString(5);
				String address = result.getString(6);
				int age = result.getInt(7);
				User user = new User(name, ID, age, password, phone, email, address);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			return null;
		}
	}
	public static boolean rentUserCart(User user){
			ShoppingCart cart = user.getCart();
			ArrayList<Pair> pairs = cart.getMovies();
			for(Pair pair : pairs){
				Movie movie = pair.getMovie();
				int duration = pair.getDuration();
				ShoppingCartDAO.removeFromCart(user, movie);
				Date startDate = new Date((new java.util.Date()).getTime());
				long newTime = (new java.util.Date()).getTime() + (duration*24*60*60*1000);
				Date endDate = new Date(newTime);
				RentDAO.insertRent(user.getID(), movie.getMovieId(), startDate, endDate);
			}
			return true;
	}
	public static Person getPerson(String userID, String userPassword){
		try {
			Connection con = DataSource.getInstance().getConnection();
			Statement statement = con.createStatement();
			String query = "select * from user where userid = " + userID + " and userpassword"
					+ " = " + userPassword + ";";
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
				ShoppingCart cart = ShoppingCartDAO.getUserCart(ID);
				user.setShoppingCart(cart);
				ArrayList<Rent> rents = RentDAO.getUserRents(ID);
				user.setRents(rents);
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
