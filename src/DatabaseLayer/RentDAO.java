package DatabaseLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Rent;

public class RentDAO {
	public static void insertRent(String userId, int movieId, Date startDate,
			Date endDate) {
		try {
			Connection connection = DataSource.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into rent values (? , ? ,? , ?)");
			preparedStatement.setString(1, userId);
			preparedStatement.setInt(2, movieId);
			preparedStatement.setDate(3, startDate);
			preparedStatement.setDate(4, endDate);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteRent(String userId, int movieId) {
       try {
		Connection connection = DataSource.getInstance().getConnection() ;
		PreparedStatement preparedStatement = connection.prepareStatement("delete from rent where userId = ?  AND movieId = ?") ; 
		preparedStatement.setString(1, userId);
		preparedStatement.setInt(2, movieId);
		preparedStatement.executeUpdate() ; 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	}
	public static ArrayList<Rent> getUserRents(String userId){
		ArrayList<Rent> rents  = new ArrayList<Rent>() ; 
		 try {
			Connection connection = DataSource.getInstance().getConnection() ;
			PreparedStatement preparedStatement = connection.prepareStatement("select* from rent where userid = ?") ; 
			ResultSet resultSet = preparedStatement.executeQuery() ; 
			 while(resultSet.next()){
				 rents.add(new Rent(userId, MoiveDao.getMovie(resultSet.getInt("movieid")), resultSet.getDate("startdate"), resultSet.getDate("enddate")));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rents;
	}
}
