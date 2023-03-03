package com.backend.BookMyShow.ServiceLayer;

import com.backend.BookMyShow.Converter.UserConvertor;
import com.backend.BookMyShow.DTOs.RequestDto.UserEntryDto;
import com.backend.BookMyShow.Models.UserEntity;
import com.backend.BookMyShow.RepositoryLayers.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDTO) {
        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDTO);


        userRepository.save(userEntity);
        return "User Added successfully";
    }

}
