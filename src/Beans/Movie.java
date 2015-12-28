package Beans;

public class Movie {
	private int movieId;
	private String movieName;
	private String movieYear;
	private float movieReating;
	private String movieType;
	private String movieDesciption;
	private int quality;
	private int quantity;
	private float price;
	private String movieCast;

	public Movie(String movieName, String movieYear, float movieReating,
			String movieType, String movieDesciption, int quality,
			int quantity, float price, String movieCast) {
		super();
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.movieReating = movieReating;
		this.movieType = movieType;
		this.movieDesciption = movieDesciption;
		this.quality = quality;
		this.quantity = quantity;
		this.price = price;
		this.movieCast = movieCast;
	}

	public Movie(int movieId, String movieName, String movieYear,
			float movieReating, String movieType, String movieDesciption,
			int quality, int quantity, float price, String movieCast) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.movieReating = movieReating;
		this.movieType = movieType;
		this.movieDesciption = movieDesciption;
		this.quality = quality;
		this.quantity = quantity;
		this.price = price;
		this.movieCast = movieCast;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(String movieYear) {
		this.movieYear = movieYear;
	}

	public float getMovieReating() {
		return movieReating;
	}

	public void setMovieReating(float movieReating) {
		this.movieReating = movieReating;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getMovieDesciption() {
		return movieDesciption;
	}

	public void setMovieDesciption(String movieDesciption) {
		this.movieDesciption = movieDesciption;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

}
