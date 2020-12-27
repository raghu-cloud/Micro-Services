package com.javabrains.MovieCatalogueService.Service;

import com.javabrains.MovieCatalogueService.model.CatalogueItem;
import com.javabrains.MovieCatalogueService.model.Movie;
import com.javabrains.MovieCatalogueService.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @HystrixCommand(fallbackMethod = "fallBackGetMovieCatalogueItem")
    public CatalogueItem getMovieCatalogueItem(Rating rating) {
        Movie movie=restTemplate.getForObject("http://MOVIEINFOSERVICE/movies/"+ rating.getMovieId(), Movie.class);
        /* calling api using web client
         * Movie movie=webClientBuilder.build() .get()
         * .uri("http://localhost:8082/movies/"+rating.getMovieId()) .retrieve()
         * .bodyToMono(Movie.class) .block();
         */
        return new CatalogueItem(movie.getOriginal_title(),movie.getOverview(), rating.getRating());
    }

    public CatalogueItem fallBackGetMovieCatalogueItem(Rating rating) {
        return  new CatalogueItem("null name","null description",rating.getRating());
    }
}
