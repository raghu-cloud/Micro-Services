package com.javabrains.MovieCatalogueService.dtos;

import java.util.Objects;

public class MovieCatalogItem {

    private String movieName;
    private String movieDescription;
    private String userId;
    private Double rating;

    public MovieCatalogItem( String movieName, String movieDescription, String userId, Double rating) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.userId = userId;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieCatalogItem{" +
                "movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", userId='" + userId + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCatalogItem that = (MovieCatalogItem) o;
        return Objects.equals(movieName, that.movieName) && Objects.equals(movieDescription, that.movieDescription) && Objects.equals(userId, that.userId) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, movieDescription, userId, rating);
    }
}
