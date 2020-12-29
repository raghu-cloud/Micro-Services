package com.javabrains.MovieCatalogueService.Service;

import com.javabrains.MovieCatalogueService.model.Rating;
import com.javabrains.MovieCatalogueService.model.RatingsObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RatingsService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBackGetUserRatings")
    public RatingsObject getUserRatings(String userId) {
        return restTemplate.getForObject("http://RATINGDATASERVICE/ratingsData/user/" + userId, RatingsObject.class);
    }

    public RatingsObject fallBackGetUserRatings(String userId) {
        RatingsObject ratingsObject = new RatingsObject();

        ratingsObject.setRatingsObject(Arrays.asList(
                new Rating("500","4"),
                new Rating("501","5")
        ));
        return ratingsObject;
    }
}
