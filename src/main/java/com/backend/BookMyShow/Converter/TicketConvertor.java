package com.backend.BookMyShow.Converter;

import com.backend.BookMyShow.DTOs.RequestDto.TicketEntryDto;
import com.backend.BookMyShow.Models.TicketEntity;
import lombok.Data;

@Data
public class TicketConvertor {
    public static TicketEntity convertEntryToEntity(TicketEntryDto ticketEntryDto){
        return new TicketEntity();
    }
}
