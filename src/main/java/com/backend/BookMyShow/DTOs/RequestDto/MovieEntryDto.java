package com.backend.BookMyShow.DTOs.RequestDto;

import com.backend.BookMyShow.Enums.Genre;
import com.backend.BookMyShow.Enums.Language;
import lombok.Data;

@Data
public class MovieEntryDto {
    private String name;
    private double rating;
    private int duration;
    private Language language;
    private Genre genre;

    public void addMovie(MovieEntryDto movieEntryDto) {
    }
}
