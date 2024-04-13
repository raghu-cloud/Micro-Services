package com.javabrains.RatingDataService.Controllers;

import com.javabrains.RatingDataService.DTOs.RatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.javabrains.RatingDataService.services.RatingService;

@RestController
@RequestMapping("/ratingsData")
public class RatingDataController {

	@Autowired
	RatingService ratingService;
	
	@RequestMapping("/getRating/{movieId}")
	public RatingDTO getRating(@PathVariable("movieId") String movieId) {
		return ratingService.getRating(movieId);
	}

	@RequestMapping(value="/saveRating", method = RequestMethod.POST)
	public RatingDTO saveRating(@RequestBody RatingDTO ratingDTO) {
		return ratingService.saveRating(ratingDTO);
	}

}
