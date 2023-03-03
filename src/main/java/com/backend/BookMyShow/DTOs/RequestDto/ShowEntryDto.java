package com.backend.BookMyShow.DTOs.RequestDto;

import com.backend.BookMyShow.Enums.ShowType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ShowEntryDto {
    private LocalDate showDate;

    private LocalTime showTime;

    private int classicSeatPrice;

    private int premiumSeatPrice;

    private  int movieId;

    private  int theaterId;


    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

}
