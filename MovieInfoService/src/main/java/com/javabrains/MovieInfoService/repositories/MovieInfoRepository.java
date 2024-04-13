package com.javabrains.MovieInfoService.repositories;

import java.util.List;

// write repository class with name MovieInfoRepository for entity class MovieInfoEntity
import com.javabrains.MovieInfoService.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findByUserId(String userId);
}
