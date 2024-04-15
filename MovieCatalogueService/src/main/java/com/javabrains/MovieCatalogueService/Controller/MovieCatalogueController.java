package com.javabrains.MovieCatalogueService.Controller;


import java.util.ArrayList;
import java.util.List;

import com.javabrains.MovieCatalogueService.Service.MovieService;
import com.javabrains.MovieCatalogueService.Service.RatingsService;
import com.javabrains.MovieCatalogueService.dtos.MovieCatalogItem;
import com.javabrains.MovieCatalogueService.dtos.MovieDTO;
import com.javabrains.MovieCatalogueService.dtos.RatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueController {

	@Autowired
	MovieService movieService;

	@Autowired
	RatingsService ratingsService;

	@RequestMapping("/users/{userId}")
	public List<MovieCatalogItem> getAllMovies(@PathVariable("userId") String userId){
		List<MovieCatalogItem> movieCatalogs = new ArrayList<MovieCatalogItem>();
		List<MovieDTO> movies =movieService.getMovies(userId);
		movies.stream().forEach(movie -> {
			RatingDTO rating = ratingsService.getUserRating(movie.getMovieId()+"");
			movieCatalogs.add(new MovieCatalogItem(movie.getName(),movie.getDescription(),userId,rating.getRating()));
		});
		return movieCatalogs;
	}

}
