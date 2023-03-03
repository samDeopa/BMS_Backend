package com.backend.BookMyShow.Converter;


import com.backend.BookMyShow.DTOs.RequestDto.UserEntryDto;
import com.backend.BookMyShow.Models.UserEntity;

public class UserConvertor {
    public  static UserEntity convertDtoToEntity(UserEntryDto userEntryDTO){
        UserEntity userEntity = UserEntity.builder()
                .name(userEntryDTO.getName())
                .age(userEntryDTO.getAge())
                .email(userEntryDTO.getEmail())
                .address(userEntryDTO.getAddress())
                .mobileNo(userEntryDTO.getMobileNo())
                .build();
        return userEntity;
    }
}
