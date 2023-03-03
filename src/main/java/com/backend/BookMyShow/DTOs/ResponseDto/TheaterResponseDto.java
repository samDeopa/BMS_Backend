package com.backend.BookMyShow.DTOs.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TheaterResponseDto {
    private  int seats;
}
