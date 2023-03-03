package com.backend.BookMyShow.Converter;

import com.backend.BookMyShow.DTOs.RequestDto.TheaterEntryDto;
import com.backend.BookMyShow.Models.TheaterEntity;
import lombok.Data;

@Data
public class TheaterConvertor {

    private TheaterConvertor(){}

    public  static TheaterEntity convertEntryDtoToEntity(TheaterEntryDto theaterEntryDto){
        return  TheaterEntity.builder()
                .name(theaterEntryDto.getName())
                .location(theaterEntryDto.getLocation())
                .build();

    }
}
