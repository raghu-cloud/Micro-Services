package com.javabrains.MovieCatalogueService.Resource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.javabrains.MovieCatalogueService.Service.MovieService;
import com.javabrains.MovieCatalogueService.Service.RatingsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
	MovieService movieService;

	@Autowired
	RatingsService ratingsService;

	@RequestMapping("/{userId}")
	public List<CatalogueItem> getAllMovies(@PathVariable("userId") String userId){

		RatingsObject ratingsObject = ratingsService.getUserRatings(userId);

		return ratingsObject.getRatingsObject().stream().map(rating-> movieService.getMovieCatalogueItem(rating))
				.collect(Collectors.toList());
	}

}
