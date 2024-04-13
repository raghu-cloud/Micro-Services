package com.javabrains.MovieInfoService.Controllers;

import com.javabrains.MovieInfoService.Entities.MovieEntity;
import com.javabrains.MovieInfoService.dtos.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.javabrains.MovieInfoService.services.MovieInfoService;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Autowired
	public MovieInfoService movieInfoService;

	@RequestMapping("/getMovies/{userId}")
	public List<MovieDTO> getMoviesByUserId(@PathVariable("userId") String userId){
		return this.movieInfoService.getMoviesByUserId(userId);
	} 	

	@RequestMapping(value = "/saveMovie",method = RequestMethod.POST)
	public MovieDTO saveMovie(@RequestBody MovieDTO movieDTO){
		return this.movieInfoService.saveMovieInfo(movieDTO);
	}
	
	@RequestMapping("/getMovieDBMovie/{theMovieDBmovieId}")
	public MovieEntity getMovieFromTheMovieDB(@PathVariable("movieId") String movieId) {
		return this.movieInfoService.getMovieFromTheMovieDB(movieId);
	}

}
