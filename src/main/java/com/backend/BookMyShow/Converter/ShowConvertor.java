package com.backend.BookMyShow.Converter;

import com.backend.BookMyShow.DTOs.RequestDto.ShowEntryDto;
import com.backend.BookMyShow.Models.ShowEntity;

public class ShowConvertor {
    public  static ShowEntity convertEntryDtoToEntity(ShowEntryDto showEntryDto){
        return  ShowEntity.builder()
                .showDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime())
                .showType(showEntryDto.getShowType())
                .build();
    }
}
