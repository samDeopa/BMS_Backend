package com.backend.BookMyShow.RepositoryLayers;

import com.backend.BookMyShow.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository  extends JpaRepository<TheaterEntity, Integer> {

    TheaterEntity findByName(String name);
}
