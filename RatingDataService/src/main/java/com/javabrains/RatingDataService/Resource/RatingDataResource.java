package com.javabrains.RatingDataService.Resource;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.RatingDataService.model.Rating;
import com.javabrains.RatingDataService.model.RatingsObject;

@RestController
@RequestMapping("/ratingsData")
public class RatingDataResource {
	
	@RequestMapping("/{userId}")
	public Rating getRating(@PathVariable("userId") String userId) {
		
		return new Rating("1", "10");
		
	}
	
	@RequestMapping("/user/{userId}")
	public RatingsObject getRatings(@PathVariable("userId") String userId) {
		ArrayList<Rating> ratings=new ArrayList<Rating>();
		ratings.add(new Rating("550","10"));
		ratings.add(new Rating("551","9"));
		RatingsObject ratingsObject = new RatingsObject();
		ratingsObject.setRatingsObject(ratings);
		return ratingsObject;
	}

}
