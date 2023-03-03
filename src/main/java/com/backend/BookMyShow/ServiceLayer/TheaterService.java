package com.backend.BookMyShow.ServiceLayer;

import com.backend.BookMyShow.Converter.TheaterConvertor;
import com.backend.BookMyShow.DTOs.RequestDto.TheaterEntryDto;
import com.backend.BookMyShow.Enums.SeatType;
import com.backend.BookMyShow.Models.TheaterEntity;
import com.backend.BookMyShow.Models.TheaterSeatEntity;
import com.backend.BookMyShow.RepositoryLayers.TheaterRepository;
import com.backend.BookMyShow.RepositoryLayers.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    public String  createTheater(TheaterEntryDto theaterEntryDto){
        TheaterEntity theaterEntity = TheaterConvertor.convertEntryDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto, theaterEntity);
        theaterEntity.setListOfTheaterSeatEntities(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);
        return "Theater Created successfully";

    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto, TheaterEntity theaterEntity) {
        int noOfClassicSeats = theaterEntryDto.getNoOfClassicSeats();
        int noOfPremiumSeats =theaterEntryDto.getNoOfPremiumSeats();
        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();
        for(int count =1;count<=noOfClassicSeats;count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatNo(count+"C")
                    .seatType(SeatType.NORMAL)
                    .theaterEntity(theaterEntity)
                    .build();
            theaterSeatEntityList.add(theaterSeatEntity);

        }
        for(int count =1;count<=noOfPremiumSeats;count++){
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatNo(count+"P")
                    .seatType(SeatType.LUXURY)
                    .theaterEntity(theaterEntity)
                    .build();
            theaterSeatEntityList.add(theaterSeatEntity);

        }

        return  theaterSeatEntityList;
    }
}
