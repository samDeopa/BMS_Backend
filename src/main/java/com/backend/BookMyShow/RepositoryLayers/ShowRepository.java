package com.backend.BookMyShow.RepositoryLayers;

import com.backend.BookMyShow.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {

}
