package com.backend.BookMyShow.ControllerLayer;

import com.backend.BookMyShow.DTOs.RequestDto.TheaterEntryDto;
import com.backend.BookMyShow.Models.ServiceLayer.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;
    @PostMapping("/add")
    public ResponseEntity createTheater(@RequestBody TheaterEntryDto theaterEntryDto){
        try {
            return new ResponseEntity(theaterService.createTheater(theaterEntryDto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Not Created", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllTheaters")
    public ResponseEntity getAllTheaters(){
        try {
            return new ResponseEntity(theaterService.getAllTheater(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getTheatersAt")
    public ResponseEntity getTheaterAt( @RequestParam String location){
        try {
            return new ResponseEntity(theaterService.getTheaterAt(location), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
