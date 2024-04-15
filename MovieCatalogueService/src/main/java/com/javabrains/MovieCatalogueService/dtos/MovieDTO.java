package com.javabrains.MovieCatalogueService.dtos;

public class MovieDTO {

    private Long movieId;
    private String name;
    private String description;
    private String userId;

    public MovieDTO() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public MovieDTO(Long movieId, String name, String description, String userId) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.userId = userId;
    }
}
