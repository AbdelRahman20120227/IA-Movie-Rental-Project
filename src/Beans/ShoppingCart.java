package Beans;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Movie> movies;
	private ArrayList<Integer> durations;
	public ShoppingCart(){
		movies = new ArrayList<Movie>();
		durations = new ArrayList<Integer>();
	}
	public void addMovie(Movie movie,int duration){
		this.movies.add(movie);
		this.durations.add(duration);
	}
}
