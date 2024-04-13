package com.javabrains.RatingDataService.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Objects;

// create JPA entity class with name RatingEntity from Rating model class with movieId and rating
@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Long ratingId;
    private String movieId;
    private Double rating;

    public Rating() {
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId=" + ratingId +
                ", movieId='" + movieId + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Rating(Long ratingId, String movieId, Double rating) {
        this.ratingId = ratingId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long id) {
        this.ratingId = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Objects.equals(ratingId, rating1.ratingId) && Objects.equals(movieId, rating1.movieId) && Objects.equals(rating, rating1.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, movieId, rating);
    }
}

