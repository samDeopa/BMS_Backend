package com.backend.BookMyShow.DTOs.RequestDto;

import lombok.Data;

import java.util.List;

@Data
public class TicketEntryDto {

    private  int showId;

    private List<String> requestedSeats;

    private  int userId;
}
