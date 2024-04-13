package com.javabrains.RatingDataService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javabrains.RatingDataService.entities.Rating;
@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    Rating findByMovieId(String movieId);
}

