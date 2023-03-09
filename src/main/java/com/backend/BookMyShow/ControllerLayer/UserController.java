package com.backend.BookMyShow.ControllerLayer;

import com.backend.BookMyShow.DTOs.RequestDto.UserEntryDto;
import com.backend.BookMyShow.Models.ServiceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDTO){
        try {
            return new ResponseEntity(userService.addUser(userEntryDTO), HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("getAllUsers")
    public  ResponseEntity gerAllUsers( ){
        try {
            return new ResponseEntity(userService.getAllUser(), HttpStatus.OK);

        }catch (Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
