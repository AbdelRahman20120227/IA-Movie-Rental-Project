package Beans;

import java.util.ArrayList;

public class ShoppingCart {
	public static class Pair{
		Movie movie;
		int duration;
		public Pair(Movie movie,int duration){
			this.movie = movie;
			this.duration = duration;
		}
		public Movie getMovie(){
			return this.movie;
		}
		public int getDuration(){
			return this.duration;
		}
	}
	private ArrayList<Pair> movies;
	public ShoppingCart(){
		movies = new ArrayList<Pair>();
	}
	public ArrayList<Pair> getMovies(){
		return this.movies;
	}
	public void addMovie(Movie movie,int duration){
		this.movies.add(new Pair(movie,duration));
	}
}
