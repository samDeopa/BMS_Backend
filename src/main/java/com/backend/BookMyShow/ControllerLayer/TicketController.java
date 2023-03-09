package com.backend.BookMyShow.ControllerLayer;

import com.backend.BookMyShow.DTOs.RequestDto.TicketEntryDto;
import com.backend.BookMyShow.Models.ServiceLayer.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @PostMapping("/book")
    public ResponseEntity addTicket(@RequestBody TicketEntryDto ticketEntryDto){
        try {
            return  new ResponseEntity(ticketService.addTicket(ticketEntryDto), HttpStatus.CREATED) ;
        }catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getBookedTicketByTicketId")
    public ResponseEntity getTicketByTicketId(@RequestParam int ticketId){
        try {
            return  new ResponseEntity(ticketService.getTicketByTicketId(ticketId), HttpStatus.OK) ;
        }catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
