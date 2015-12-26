package DatabaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Movie;

public class MoiveDao {
	public static void insertMoive(Movie movie) {
		try {
			Connection connection = DataSource.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into movie (moviename , movieyear , movierating , movietype , moviedescription , quality , quantity , price , moviecast) values(? , ? , ? , ? , ? , ?  , ? , ? , ?)");
			preparedStatement.setString(1, movie.getMovieName());
			preparedStatement.setString(2, movie.getMovieYear());
			preparedStatement.setFloat(3, movie.getMovieReating());
			preparedStatement.setString(4, movie.getMovieType());
			preparedStatement.setString(5, movie.getMovieDesciption());
			preparedStatement.setInt(6, movie.getQuality());
			preparedStatement.setInt(7, movie.getQuantity());
			preparedStatement.setFloat(8, movie.getPrice());
			preparedStatement.setString(9, movie.getMovieCast());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateMovie(Movie movie) {
		try {
			Connection connection = DataSource.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update movie set moviename=? , movieyear = ?  ,  movierating = ?  , movietype = ? , moviedescription = ? , quality = ? ,  quantity = ? , price = ?  , moviecast = ? where movieid = ?");
			preparedStatement.setString(1, movie.getMovieName());
			preparedStatement.setString(2, movie.getMovieYear());
			preparedStatement.setFloat(3, movie.getMovieReating());
			preparedStatement.setString(4, movie.getMovieType());
			preparedStatement.setString(5, movie.getMovieDesciption());
			preparedStatement.setInt(6, movie.getQuality());
			preparedStatement.setInt(7, movie.getQuantity());
			preparedStatement.setFloat(8, movie.getPrice());
			preparedStatement.setString(9, movie.getMovieCast());
			preparedStatement.setInt(10, movie.getMovieId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Movie getMovie(int movieId) {
		try {
			Connection connection = DataSource.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select* from movies where movieid = ? ");
			preparedStatement.setInt(1, movieId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new Movie(resultSet.getInt("movieid"),
						resultSet.getString("movieName"),
						resultSet.getString("movieYear"),
						resultSet.getFloat("movieReating"),
						resultSet.getString("movieType"),
						resultSet.getString("movieDesciption"),
						resultSet.getInt("quality"),
						resultSet.getInt("quantity"),
						resultSet.getFloat("price"),
						resultSet.getString("movieCast"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
