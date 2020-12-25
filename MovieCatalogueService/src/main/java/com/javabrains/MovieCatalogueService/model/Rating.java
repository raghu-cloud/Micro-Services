package com.javabrains.MovieCatalogueService.model;

public class Rating {
	
	String movieId;
	String rating;
	
	public Rating() {
		
	}
	
	
	public Rating(String movieId, String rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}


	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
	

}
