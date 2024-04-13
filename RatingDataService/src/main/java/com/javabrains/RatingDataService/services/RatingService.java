package com.javabrains.RatingDataService.services;

// create a service class for RatingService class 
import com.javabrains.RatingDataService.DTOs.RatingDTO;
import com.javabrains.RatingDataService.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javabrains.RatingDataService.entities.Rating;
@Service
public class RatingService{

    @Autowired 
    RatingRepository ratingRepository;

    // write service method to getRating by movieId for repository class RatingRepository
    public RatingDTO getRating(String movieId){
        Rating ratingEntity = ratingRepository.findByMovieId(movieId);
        if(ratingEntity!=null){
            return new RatingDTO(ratingEntity.getRatingId(),ratingEntity.getMovieId(),ratingEntity.getRating());
        }
        return new RatingDTO(0L,"0",0.0);
    }

    public RatingDTO saveRating(RatingDTO rating){
        Rating reqRatingEntity = new Rating(rating.getRatingId(), rating.getMovieId(), rating.getRating());
        Rating resRatingEntity = ratingRepository.save(reqRatingEntity);
        return new RatingDTO(resRatingEntity.getRatingId(), resRatingEntity.getMovieId(), resRatingEntity.getRating());
    }
        
}

