package com.backend.BookMyShow.Converter;

import com.backend.BookMyShow.DTOs.RequestDto.MovieEntryDto;
import com.backend.BookMyShow.Models.MovieEntity;

public class MovieConvertor {
    //declaring a private constructor because this class is not meant to be instantiated
    private MovieConvertor() {
    }

    public  static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){
        return MovieEntity.builder()
                .name(movieEntryDto.getName())
                .genre(movieEntryDto.getGenre())
                .rating(movieEntryDto.getRating())
                .duration(movieEntryDto.getDuration())
                .language(movieEntryDto.getLanguage())
                .build();
    }
}
