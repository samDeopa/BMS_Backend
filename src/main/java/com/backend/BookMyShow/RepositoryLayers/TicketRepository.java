package com.backend.BookMyShow.RepositoryLayers;

import com.backend.BookMyShow.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

}
