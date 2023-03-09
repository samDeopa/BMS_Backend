package com.backend.BookMyShow.RepositoryLayers;

import com.backend.BookMyShow.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    //retrieve a movie name using movie name;
    MovieEntity findByName(String name);
}
