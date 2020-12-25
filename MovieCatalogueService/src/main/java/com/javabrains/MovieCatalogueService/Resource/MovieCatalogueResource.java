package com.javabrains.MovieCatalogueService.Resource;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.javabrains.MovieCatalogueService.model.*;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogueItem> getAllMovies(@PathVariable("userId") String userId){
		
		RatingsObject ratingsObject = restTemplate.getForObject("http://RATINGDATASERVICE/ratingsData/user/"+userId,RatingsObject.class);
		
		
		return ratingsObject.getRatingsObject().stream().map(rating-> {
			Movie movie=restTemplate.getForObject("http://MOVIEINFOSERVICE/movies/"+rating.getMovieId(), Movie.class);
			/*
			 * Movie movie=webClientBuilder.build() .get()
			 * .uri("http://localhost:8082/movies/"+rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
				return new CatalogueItem(movie.getMovieName(),movie.getMovieDesc(),rating.getRating());
		}).collect(Collectors.toList());
		
		
	}
	

}
