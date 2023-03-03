package com.backend.BookMyShow.ServiceLayer;

import com.backend.BookMyShow.ControllerLayer.ShowController;
import com.backend.BookMyShow.Converter.ShowConvertor;
import com.backend.BookMyShow.DTOs.RequestDto.ShowEntryDto;
import com.backend.BookMyShow.Enums.SeatType;
import com.backend.BookMyShow.Models.*;
import com.backend.BookMyShow.RepositoryLayers.MovieRepository;
import com.backend.BookMyShow.RepositoryLayers.ShowRepository;
import com.backend.BookMyShow.RepositoryLayers.TheaterRepository;
import com.backend.BookMyShow.RepositoryLayers.TheaterSeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.rmi.server.LogStream.log;


@Service
public class ShowService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowRepository showRepository;
    public String addShow(ShowEntryDto showEntryDto) {
        Logger logger = LoggerFactory.getLogger(ShowService.class);


        ShowEntity showEntity =  ShowConvertor.convertEntryDtoToEntity(showEntryDto);

        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieId()).get();
        logger.warn(showEntryDto.getTheaterId() +"");

        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterId()).get();
        logger.warn(theaterEntity.getName());
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);



        List<ShowSeatEntity> showSeatEntityList = createShowSeats(showEntryDto, showEntity);

        showEntity.setListOfShowSeats( showSeatEntityList);

        showEntity = showRepository.save(showEntity);

        List<ShowEntity> showEntityList = movieEntity.getListOfShowEntities();
        showEntityList.add(showEntity);
        movieEntity.setListOfShowEntities(showEntityList);

        movieRepository.save(movieEntity);

        List<ShowEntity> showEntityList2 = theaterEntity.getListOfShowEntities();
        showEntityList2.add(showEntity);
        theaterEntity.setListOfShowEntities(showEntityList2);

        theaterRepository.save(theaterEntity);

        return "Show added successfully";
    }
    private static List<ShowSeatEntity> createShowSeats(ShowEntryDto showEntryDto, ShowEntity showEntity){
        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
        List<TheaterSeatEntity> theaterSeatEntityList = showEntity.getTheaterEntity().getListOfTheaterSeatEntities();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){
            ShowSeatEntity showSeatEntity = new ShowSeatEntity();
            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());
            showSeatEntity.setPrice( theaterSeatEntity.getSeatType()== SeatType.NORMAL?showEntryDto.getClassicSeatPrice():showEntryDto.getPremiumSeatPrice() );
            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity);

            showSeatEntityList.add(showSeatEntity);
        }
        return  showSeatEntityList;
    }
}
