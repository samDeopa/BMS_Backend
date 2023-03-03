package com.backend.BookMyShow.ControllerLayer;

import com.backend.BookMyShow.Converter.TheaterConvertor;
import com.backend.BookMyShow.DTOs.RequestDto.TheaterEntryDto;
import com.backend.BookMyShow.Enums.SeatType;
import com.backend.BookMyShow.Models.TheaterEntity;
import com.backend.BookMyShow.Models.TheaterSeatEntity;
import com.backend.BookMyShow.ServiceLayer.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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


}
