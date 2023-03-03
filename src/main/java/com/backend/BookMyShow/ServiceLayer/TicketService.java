package com.backend.BookMyShow.ServiceLayer;

import com.backend.BookMyShow.DTOs.RequestDto.TicketEntryDto;
import com.backend.BookMyShow.Enums.SeatType;
import com.backend.BookMyShow.Models.ShowEntity;
import com.backend.BookMyShow.Models.ShowSeatEntity;
import com.backend.BookMyShow.Models.TicketEntity;
import com.backend.BookMyShow.Models.UserEntity;
import com.backend.BookMyShow.RepositoryLayers.ShowRepository;
import com.backend.BookMyShow.RepositoryLayers.TicketRepository;
import com.backend.BookMyShow.RepositoryLayers.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.ListView;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;

    public String addTicket(TicketEntryDto ticketEntryDto) throws Exception {
        TicketEntity ticketEntity =  new TicketEntity();

        int totalAmount = isValidAndAmount(ticketEntryDto);

        ticketEntity.setTotalAmount(totalAmount);

        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        String allottedSeats = getAllottedSeats( requestedSeats );
        ticketEntity.setBookedSeats(allottedSeats);

        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();

        ticketEntity.setMovieName(showEntity.getMovieEntity().getName() )  ;

        ticketEntity.setShowDate(showEntity.getShowDate());
        ticketEntity.setShowTime(showEntity.getShowTime());
        ticketEntity.setTheaterName(showEntity.getTheaterEntity().getName());

        ticketEntity.setShowEntity(showEntity);

        List<TicketEntity> ticketEntityList = showEntity.getListOfBookedTickets();
        ticketEntityList.add(ticketEntity);
        showEntity.setListOfBookedTickets(ticketEntityList);

        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();
        ticketEntity.setUserEntity( userEntity);

        ticketRepository.save(ticketEntity);

        showRepository.save(showEntity);




        ticketEntityList = userEntity.getListOfTicketEntities();
        ticketEntityList.add(ticketEntity);
        userEntity.setListOfTicketEntities(ticketEntityList);

        userRepository.save(userEntity);
        return  "Created Successfully";

    }

    private String getAllottedSeats(List<String> requestedSeats) {
        String ans ="";
        for(String s: requestedSeats){
            ans = ans+", " + s;
        }
        return  ans.substring(2);
    }

    private int isValidAndAmount(TicketEntryDto ticketEntryDto) throws Exception {
        int amount = 0;
        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();

        List<String> listOfRequestedSeats = ticketEntryDto.getRequestedSeats();

        List<ShowSeatEntity> showSeatEntityList = showEntity.getListOfShowSeats();

        for(ShowSeatEntity showSeatEntity : showSeatEntityList){
           String seatNo = showSeatEntity.getSeatNo();
           if( listOfRequestedSeats.contains(seatNo) && showSeatEntity.isBooked() ){
               throw new Exception("Seats already Booked");
           }
        }

        for(ShowSeatEntity showSeatEntity : showSeatEntityList){
            String seatNo = showSeatEntity.getSeatNo();
            if( listOfRequestedSeats.contains(seatNo)  ){
                amount += showSeatEntity.getPrice();
                showSeatEntity.setBooked(true);
                showSeatEntity.setBookedAt(new Date());
            }
        }

        return amount;

    }
}
