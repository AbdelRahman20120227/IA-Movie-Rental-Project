package Beans;

import java.sql.Date;

public class Rent {
	private User user;
	private Movie movie;
	private Date endDate;
	private Date startDate ;
	
	
	public Rent(User user, Movie movie, Date endDate, Date startDate) {
		super();
		this.user = user;
		this.movie = movie;
		this.endDate = endDate;
		this.startDate = startDate;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	} 
	 
}
