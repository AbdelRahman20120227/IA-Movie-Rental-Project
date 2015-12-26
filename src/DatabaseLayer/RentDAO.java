package DatabaseLayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
