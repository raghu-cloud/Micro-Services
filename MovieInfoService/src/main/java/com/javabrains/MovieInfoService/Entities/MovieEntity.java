package com.javabrains.MovieInfoService.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Objects;

// generate JPA entity class with name MovieInfoEntity from Movie model class with id, title and overview
@Entity
public class MovieEntity {
    @Id
    @GeneratedValue
	public Long movieId;
	public String name;
	public String description;
	public String userId;

	public MovieEntity(){

	}

	public MovieEntity(Long movieId, String name, String description, String userId) {
		this.movieId = movieId;
		this.name = name;
		this.description = description;
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long id) {
		this.movieId = id;
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

	@Override
	public String toString() {
		return "Movie{" +
				"id='" + movieId + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", userId='" + userId + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MovieEntity movieEntity = (MovieEntity) o;
		return Objects.equals(movieId, movieEntity.movieId) && Objects.equals(name, movieEntity.name) && Objects.equals(description, movieEntity.description) && Objects.equals(userId, movieEntity.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, name, description, userId);
	}
}

