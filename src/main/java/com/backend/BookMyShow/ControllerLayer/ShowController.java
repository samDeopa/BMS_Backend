package com.backend.BookMyShow.ControllerLayer;

import com.backend.BookMyShow.DTOs.RequestDto.ShowEntryDto;
import com.backend.BookMyShow.Models.ServiceLayer.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity addShow(@RequestBody ShowEntryDto showEntryDto){
        try {
            return new ResponseEntity(showService.addShow(showEntryDto), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getShowsByMovieName")
    public  ResponseEntity getShowsByMovieName(@RequestParam("movieName") String movieName){
        try {
            return  new ResponseEntity(showService.getShowsByMovieName(movieName), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getShowsByTheaterName")
    public  ResponseEntity getShowByTheaterId(@RequestParam("theaterName") String theaterName){
        try {
            return  new ResponseEntity(showService.getShowsByTheaterName(theaterName), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
