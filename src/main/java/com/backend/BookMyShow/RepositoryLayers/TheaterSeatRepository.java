package com.backend.BookMyShow.RepositoryLayers;

import com.backend.BookMyShow.Models.TheaterEntity;
import com.backend.BookMyShow.Models.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity, Integer> {

}
