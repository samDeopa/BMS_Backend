package com.backend.BookMyShow.RepositoryLayers;

import com.backend.BookMyShow.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository  extends JpaRepository<TheaterEntity, Integer> {
}
