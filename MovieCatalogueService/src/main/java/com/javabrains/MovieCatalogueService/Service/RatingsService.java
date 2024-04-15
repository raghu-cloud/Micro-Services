package com.javabrains.MovieCatalogueService.Service;

import com.javabrains.MovieCatalogueService.dtos.RatingDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingsService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBackGetUserRating")
    public RatingDTO getUserRating(String movieId) {
        RatingDTO ratingDTO =  restTemplate.getForObject("http://RATINGDATASERVICE/ratingsData/getRating/" + movieId, RatingDTO.class);
        return ratingDTO;
    }

    public RatingDTO fallBackGetUserRating(String userId) {
        return new RatingDTO(0L,"0",0.0);
    }
}
