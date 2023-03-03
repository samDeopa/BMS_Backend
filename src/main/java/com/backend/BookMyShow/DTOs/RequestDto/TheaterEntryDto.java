package com.backend.BookMyShow.DTOs.RequestDto;

import lombok.Data;

@Data
public class TheaterEntryDto {
    private  String name;
    private  String location;
    private  int noOfClassicSeats;
    private  int noOfPremiumSeats;

}
