package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Beans.Movie;
import Beans.ShoppingCart;
import Beans.User;

public class ShoppingCartDAO {
	public static ShoppingCart getUserCart(String ID){
		try {
			Connection con = DataSource.getInstance().getConnection();
			Statement statement = con.createStatement();
			String query = "select * from shoppingcart where userid = '" + ID + "';";
			ResultSet result = statement.executeQuery(query);
			ShoppingCart cart = new ShoppingCart();
			while(result.next()){
				int count = result.getInt("count");
				Movie movie = MovieDAO.getMovie(result.getInt("movieid"));
				int quantity = movie.getQuantity();
				updateCount(ID,movie.getMovieId(),Math.min(quantity, count));
				for(int i=0;i<Math.min(count, quantity);i++){
					cart.addMovie(movie, result.getInt("duration"));
				}
			}
			return cart;
		} catch (SQLException e) {
			return null;
		}
	}
	public static boolean removeFromCart(User user, Movie movie){
		try {
			Connection con = DataSource.getInstance().getConnection();
			String deleteQuery = "delete from shoppingcart where userid = ? and movieid = ?";
			PreparedStatement statement = con.prepareStatement(deleteQuery);
			statement.setString(1, user.getID());
			statement.setInt(2, movie.getMovieId());
			statement.executeQuery();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public static boolean updateCount(String userID, int movieID,int newCount){
		try {
			Connection con = DataSource.getInstance().getConnection();
			String updateQuery = "update shoppingcart set count = ? where userid = ? and movieid = ?";
			PreparedStatement statement = con.prepareStatement(updateQuery);
			statement.setInt(1, newCount);
			statement.setString(2,userID);
			statement.setInt(3, movieID);
			statement.executeUpdate(updateQuery);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public static String addMovieToCart(User user, Movie movie,int duration){
		try {
			Connection con = DataSource.getInstance().getConnection();
			String checkQuery = "select * from shoppingcart where userid = ? and movieid = ?;";
			PreparedStatement queryStatement = con.prepareStatement(checkQuery);
			queryStatement.setString(1, user.getID());
			queryStatement.setInt(2, movie.getMovieId());
			ResultSet result = queryStatement.executeQuery();
			if(result.next()){
				updateCount(user.getID(), movie.getMovieId(), Math.min(result.getInt("count")+1,movie.getQuantity()));
				return "updated";
			}
			else{
				String insertStr = "insert into shopping cart values(?,?,?,?);";
				PreparedStatement insertStatement = con.prepareStatement(insertStr);
				insertStatement.setString(1, user.getID());
				insertStatement.setInt(2, movie.getMovieId());
				insertStatement.setInt(3, duration);
				insertStatement.setInt(4, 1);
				insertStatement.executeUpdate();
				return "new";
			}
		} catch (SQLException e) {
			return "error";
		}
	}
}
