package Beans;

import java.sql.Date;

public class Rent {
	User user;
	Movie movie;
	Date endDate;
	public Rent(User user, Movie movie, Date endDate){
		this.user = user;
		this.movie = movie;
		this.endDate = endDate;
	}
}
