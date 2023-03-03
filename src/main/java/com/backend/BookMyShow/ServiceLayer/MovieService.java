package com.backend.BookMyShow.ServiceLayer;

import com.backend.BookMyShow.Converter.MovieConvertor;
import com.backend.BookMyShow.DTOs.RequestDto.MovieEntryDto;
import com.backend.BookMyShow.Models.MovieEntity;
import com.backend.BookMyShow.RepositoryLayers.MovieRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieEntryDto movieEntryDto) throws  Exception{
        MovieEntity movieEntity = MovieConvertor.convertEntryDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "movie added Successfully";
    }
}
