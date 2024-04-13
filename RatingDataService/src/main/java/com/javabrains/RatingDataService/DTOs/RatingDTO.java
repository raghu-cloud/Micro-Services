package com.javabrains.RatingDataService.DTOs;

import java.util.Objects;

public class RatingDTO {

    private Long ratingId;
    private String movieId;
    private Double rating;

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
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

    public RatingDTO(Long ratingId, String movieId, Double rating) {
        this.ratingId = ratingId;
        this.movieId = movieId;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RatingDTO{" +
                "ratingId=" + ratingId +
                ", movieId='" + movieId + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingDTO ratingDTO = (RatingDTO) o;
        return Objects.equals(ratingId, ratingDTO.ratingId) && Objects.equals(movieId, ratingDTO.movieId) && Objects.equals(rating, ratingDTO.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, movieId, rating);
    }
}
