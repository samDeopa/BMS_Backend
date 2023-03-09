package com.backend.BookMyShow.Models.ServiceLayer;

import com.backend.BookMyShow.Converter.MovieConvertor;
import com.backend.BookMyShow.DTOs.RequestDto.MovieEntryDto;
import com.backend.BookMyShow.Models.MovieEntity;
import com.backend.BookMyShow.RepositoryLayers.MovieRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Service
@Data
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<String> getAllMovies() {
        List<String > movieList = new ArrayList<>();

        List<MovieEntity> movieEntityList = movieRepository.findAll();
        for(MovieEntity movie : movieEntityList){
            movieList.add( movie.getId() +" : "+ movie.getName()  );
        }
        return  movieList;
    }

    public String addMovie(MovieEntryDto movieEntryDto) throws  Exception{
        MovieEntity movieEntity = MovieConvertor.convertEntryDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "movie added Successfully";
    }
}
