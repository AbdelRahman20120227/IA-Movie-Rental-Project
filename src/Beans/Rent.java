package Beans;

import java.sql.Date;

public class Rent {
	private String userId;
	private Movie movie;
	private Date startDate;
	private Date endDate;

	public Rent(String userId, Movie movie, Date startDate, Date endDate) {
		super();
		this.userId = userId;
		this.movie = movie;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
