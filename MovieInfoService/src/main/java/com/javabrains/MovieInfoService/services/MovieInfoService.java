package com.javabrains.MovieInfoService.services;

import java.util.List;
import java.util.stream.Collectors;

import com.javabrains.MovieInfoService.dtos.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import com.javabrains.MovieInfoService.Entities.MovieEntity;
import com.javabrains.MovieInfoService.repositories.MovieInfoRepository;
import org.springframework.web.client.RestTemplate;
@Service
public class MovieInfoService {

    @Value("${api.key}")
	public String apiKey;

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Autowired
    private RestTemplate restTemplate;

    // write a service method to save movie info
    public MovieDTO saveMovieInfo(MovieDTO movieDTO) {
        MovieEntity movieEntity = new MovieEntity(movieDTO.getMovieId(), movieDTO.getName(), movieDTO.getDescription(), movieDTO.getUserId());
        MovieEntity respMovieEntity = movieInfoRepository.save(movieEntity);
        return new MovieDTO(respMovieEntity.getMovieId(), respMovieEntity.getName(), respMovieEntity.getDescription(), respMovieEntity.getUserId());
    }

    public MovieEntity getMovieFromTheMovieDB(String movieId) {
        return restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey, MovieEntity.class);
    }

    public List<MovieDTO> getMoviesByUserId(String userId) {
        return movieInfoRepository.findByUserId(userId).stream().map(movieEntity ->
            new MovieDTO(movieEntity.getMovieId(),movieEntity.getName(),
                    movieEntity.getDescription(),movieEntity.getUserId())
        ).collect(Collectors.toList());
    }   



}
