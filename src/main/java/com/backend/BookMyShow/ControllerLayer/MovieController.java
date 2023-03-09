package com.backend.BookMyShow.ControllerLayer;

import com.backend.BookMyShow.DTOs.RequestDto.MovieEntryDto;
import com.backend.BookMyShow.Models.ServiceLayer.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody MovieEntryDto movieEntryDto){
        try {
            return new ResponseEntity<>(movieService.addMovie(movieEntryDto), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getAllMovies")
    public  ResponseEntity getAllMovies(){
        try {
            return new ResponseEntity(movieService.getAllMovies(), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

}
