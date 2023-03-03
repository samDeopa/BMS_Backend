package com.backend.BookMyShow.ControllerLayer;

import com.backend.BookMyShow.DTOs.RequestDto.MovieEntryDto;
import com.backend.BookMyShow.ServiceLayer.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/addMocie")
    public ResponseEntity addMovie(@RequestBody MovieEntryDto movieEntryDto){
        try {
            return new ResponseEntity<>(movieService.addMovie(movieEntryDto), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return  new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

    }

}
