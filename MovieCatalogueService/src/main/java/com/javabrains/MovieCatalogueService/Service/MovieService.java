package com.javabrains.MovieCatalogueService.Service;


import com.javabrains.MovieCatalogueService.dtos.MovieDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webclient;

    //@HystrixCommand(fallbackMethod = "fallBackGetMovies")
    public List<MovieDTO> getMovies(String userId) {
        ParameterizedTypeReference<List<MovieDTO>> typeRef
                = new ParameterizedTypeReference<List<MovieDTO>>() {
        };
        ResponseEntity<List<MovieDTO>> response = restTemplate.exchange(
                "http://MOVIEINFOSERVICE/movies/getMovies/"+userId,
                HttpMethod.GET,
                null,
                typeRef);
        return response.getBody();
    }

   /* public List<MovieDTO> fallBackGetMovies(String  userId) {
        List<MovieDTO> movies = Arrays.asList(
                new MovieDTO(0L, "Defult Movie", "Defult Movie", "0")
        );
        return movies;
    }*/
}
